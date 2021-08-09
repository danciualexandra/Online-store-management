package com.proiect_PS.resurse.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Positive;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Employee extends User {
    @Range(min=100000,max=999999)
    private Integer zipCode;
    @Positive
    private double salary;


    @Builder
    public Employee(Long id,String userName,String password,String firstName,String lastName,String email,String address,String phone,String gender,Integer zipCode, double salary){
       super(id,userName,password,firstName,lastName,email,address,phone,gender);
        this.zipCode=zipCode;
        this.salary=salary;

    }




}
