package com.proiect_PS.resurse.service;

import com.proiect_PS.resurse.dto.EmployeeDetailsDTO;
import com.proiect_PS.resurse.dto.EmployeeSuccesDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee findUserName(String username);
   Employee findPassword(String password);
    Employee saveEmployee(Employee employee);
    Employee findUsernameAndPassword(String username, String password) throws ApiExceptionResponse;
    void deleteEmployee(Employee employee);
    Employee findById(Long id);
    Employee deleteEmployee(Long id);

    List<EmployeeDetailsDTO> findEmployeeDetails();
    EmployeeSuccesDTO addEmployee(EmployeeDetailsDTO dto) throws ApiExceptionResponse;
    Employee updateEmployee(Long id, EmployeeDetailsDTO dto) throws ApiExceptionResponse;

}
