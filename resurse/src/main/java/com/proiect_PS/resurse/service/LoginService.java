package com.proiect_PS.resurse.service;

import com.proiect_PS.resurse.dto.CredentialsDTO;
import com.proiect_PS.resurse.dto.LoginSuccesDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import org.springframework.stereotype.Component;

@Component
public interface LoginService {
    LoginSuccesDTO login(CredentialsDTO dto) throws ApiExceptionResponse;
    boolean logout(String sto);
    public int findNrOfUsers();
}
