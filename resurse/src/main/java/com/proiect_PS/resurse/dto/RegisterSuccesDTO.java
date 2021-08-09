package com.proiect_PS.resurse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterSuccesDTO {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String gender;
    private Integer zipCode;

    private Long id;
}
