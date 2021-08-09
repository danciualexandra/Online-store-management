package com.proiect_PS.resurse.service;

import com.proiect_PS.resurse.dto.RegisterCredentialsDTO;
import com.proiect_PS.resurse.dto.RegisterSuccesDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import org.springframework.stereotype.Component;

@Component
public interface RegisterService {
    RegisterSuccesDTO register(RegisterCredentialsDTO dto) throws ApiExceptionResponse;
}
