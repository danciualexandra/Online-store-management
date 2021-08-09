package com.proiect_PS.resurse.controller;

import com.proiect_PS.resurse.dto.CredentialsDTO;
import com.proiect_PS.resurse.dto.RegisterCredentialsDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.service.LoginService;
import com.proiect_PS.resurse.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity registerReq(@RequestBody RegisterCredentialsDTO dto) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(registerService.register(dto));
    }
}
