package com.proiect_PS.resurse.model;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Admin extends User{
    private double salary;

    @Builder
    public Admin(Long id,String userName,String password, String firstName, String lastName,String email,String address, String phone,String gender,double salary) {
        super(id, userName,password,firstName,lastName,email, address, phone,gender);
        this.salary=salary;
    }



}
