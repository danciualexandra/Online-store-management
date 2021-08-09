package com.proiect_PS.resurse.dto;

import com.proiect_PS.resurse.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailsDTO {
    @Size(min=2,max=50)
    private String userName;
    @Size(min=4,max=50)
    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String email;
    @NotNull
    private String address;
    @Size(min=10,max=10)
    private String phone;
    @Size(min=1,max=1)
    private String gender;
    @Range(min=100000,max=999999)
    private Integer zipCode;
    @Positive
    private double salary;

    public void populateFrom(Employee employee){
        this.userName=employee.getUserName();
        this.firstName=employee.getFirstName();
        this.lastName=employee.getLastName();
        this.email=employee.getEmail();
        this.address=employee.getAddress();
        this.phone=employee.getPhone();
        this.gender=employee.getGender();
        this.zipCode=employee.getZipCode();
        this.salary=employee.getSalary();

    }
}
