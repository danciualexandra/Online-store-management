package com.proiect_PS.resurse.service.impl;

import com.proiect_PS.resurse.dto.EmployeeDetailsDTO;
import com.proiect_PS.resurse.dto.EmployeeSuccesDTO;

import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.repository.EmployeeRepository;
import com.proiect_PS.resurse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee findUserName(String username){
        return employeeRepository.findFirstByUserName(username);
    }
    public Employee findPassword(String password){
        return employeeRepository.findFirstByPassword(password);
    }
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findUsernameAndPassword(String username, String password) throws ApiExceptionResponse {

        Employee employee=employeeRepository.findFirstByUserNameAndPassword(username,password);
        if(employee==null){
            ArrayList<String> errors=new ArrayList<>();
            errors.add("Might not exist with username"+username);
            errors.add("Might not exist with password "+password);
            errors.add("Might not find by the pair provided");
            throw ApiExceptionResponse.builder().errors(errors)
                    .message("Entity not found").status(HttpStatus.NOT_FOUND).build();
        }
        return employee;


    }

    @Override
    public void deleteEmployee(Employee employee) {
     employeeRepository.delete(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findFirstById(id);
    }

    @Override
    public Employee deleteEmployee(Long id) {
        Employee employee=employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return employee;
    }

    public List<EmployeeDetailsDTO> findEmployeeDetails(){
        List<Employee> employees= (List<Employee>) employeeRepository.findAll();
       return employees.stream().map(employee->{
            EmployeeDetailsDTO employeeDetailsDTO =new EmployeeDetailsDTO();
            employeeDetailsDTO.populateFrom(employee);
            return employeeDetailsDTO;
        }).collect(Collectors.toList());

    }

    @Override
    public EmployeeSuccesDTO addEmployee(EmployeeDetailsDTO dto) throws ApiExceptionResponse {
        String userName=dto.getUserName();
        String firstName=dto.getFirstName();
        String password=dto.getPassword();
        String lastName=dto.getLastName();
        String email=dto.getEmail();
        String address=dto.getAddress();
        String phone=dto.getPhone();
        String gender=dto.getGender();
        Integer zipCode=dto.getZipCode();
        double salary=dto.getSalary();


        EmployeeSuccesDTO response;
        Employee employee1=employeeRepository.findFirstByUserNameAndPassword(dto.getUserName(),dto.getPassword());
        if(employee1==null) {

            response=EmployeeSuccesDTO.builder().firstName(firstName).lastName(lastName).userName(userName).password(password).email(email).address(address).phone(phone).gender(gender).zipCode(zipCode).salary(salary).build();
            Employee employee= new Employee();
            employee.setUserName(userName);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setGender(gender);
            employee.setSalary(salary);
            employee.setZipCode(zipCode);
            employee.setAddress(address);
            employee.setPhone(phone);
            employee.setPassword(password);

            employeeRepository.save(employee);

            return response;

        }else throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials"))
                .message("Employee already exists can not use the same username and password").status(HttpStatus.NOT_FOUND).build();




    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDetailsDTO dto) throws ApiExceptionResponse {

        String userName=dto.getUserName();
        String firstName=dto.getFirstName();
        String password=dto.getPassword();
        String lastName=dto.getLastName();
        String email=dto.getEmail();
        String address=dto.getAddress();
        String phone=dto.getPhone();
        String gender=dto.getGender();
        Integer zipCode=dto.getZipCode();
        double salary=dto.getSalary();

        Employee employee=employeeRepository.findFirstById(id);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPhone(phone);
        employee.setGender(gender);
        employee.setZipCode(zipCode);
        employee.setSalary(salary);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(userName);
        employee.setPassword(password);

      return employeeRepository.save(employee);




    }

}
