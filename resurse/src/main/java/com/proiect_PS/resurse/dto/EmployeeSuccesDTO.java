package com.proiect_PS.resurse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class EmployeeSuccesDTO {
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

    private Long id;

}
