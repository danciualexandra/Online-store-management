package com.proiect_PS.resurse.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    @Size(min=2,max=50)
    private String userName;

    private String password;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String email;
    @NotNull
    private String address;

    @Size(min=10 ,max=10)
    private String phone;
    @Size(min=1 ,max=1)
    private String gender;



}
