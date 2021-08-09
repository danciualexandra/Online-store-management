package com.proiect_PS.resurse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginSuccesDTO {

    private String role;
    private Long id;
}
