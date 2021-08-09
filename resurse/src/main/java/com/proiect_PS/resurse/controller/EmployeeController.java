package com.proiect_PS.resurse.controller;

import com.proiect_PS.resurse.dto.EmployeeDetailsDTO;
import com.proiect_PS.resurse.dto.RegisterCredentialsDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.model.Product;
import com.proiect_PS.resurse.repository.EmployeeRepository;
import com.proiect_PS.resurse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@PreAuthorize("hasAnyRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")

    public ResponseEntity getAllEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody  Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.saveEmployee(employee));
    }
    @PostMapping("/admin-home/create-employee")
    public ResponseEntity addEmployeeReq(@RequestBody @Valid EmployeeDetailsDTO dto) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.addEmployee(dto));

    }
    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
    }



    @GetMapping("/details")
    public ResponseEntity findEmployeeDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findEmployeeDetails());
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmployee(id));
    }

    @PutMapping("/admin-home/update-employee/{id}")
    public ResponseEntity updateEmployeeReq(@PathVariable Long id,@RequestBody EmployeeDetailsDTO dto)throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(id,dto));
    }




}
