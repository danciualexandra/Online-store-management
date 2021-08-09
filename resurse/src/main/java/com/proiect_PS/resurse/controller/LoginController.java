package com.proiect_PS.resurse.controller;

import com.proiect_PS.resurse.dto.CredentialsDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login/success")
    public ResponseEntity loginReq(@RequestBody CredentialsDTO dto) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(dto));
    }
    @PostMapping("/logout")
    public ResponseEntity logoutReq(@RequestBody String dto) throws ApiExceptionResponse {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.logout(dto));
    }
    @GetMapping("/connected-users")
    public ResponseEntity findNrOfUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(loginService.findNrOfUsers());
    }
}
