package com.proiect_PS.resurse;

import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

   /* @Test
    public void testAddEmployee(){
        Employee employee=new Employee();
        employee.setId(null);
        //employee.setProducts(null);
        employee.setSalary(2000.0);
        employee.setUserName("marcel");
        employee.setPassword("marcel");
        employee.setFirstName("Pop");
        employee.setLastName("Marcel");
        employee.setEmail("marcel@yahoo.com");
        employee.setAddress("Bucuresti");
        employee.setPhone("0722222222");
        employee.setGender("m");
        employee.setZipCode(540257);
        employeeService.saveEmployee(employee);
        ArrayList<Employee> employees=new ArrayList<>();
        employees.add(employee);

        Assertions.assertTrue(employee.getId()!=null);
    }
    @Test
    public void testEmployeeListNotEmpty(){

        List<Employee> employees=employeeService.getAllEmployees();
        Assertions.assertFalse(employees.isEmpty());
    }*/



}
