package com.proiect_PS.resurse.service.impl;

import com.proiect_PS.resurse.dto.CredentialsDTO;
import com.proiect_PS.resurse.dto.LoginSuccesDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.model.User;
import com.proiect_PS.resurse.repository.UserRepository;
import com.proiect_PS.resurse.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    Map<Long, Integer> hm = new HashMap<Long, Integer>();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginSuccesDTO login(CredentialsDTO dto) throws ApiExceptionResponse {
      User user=userRepository.findFirstByUserName(dto.getUsername());

        if(user==null) {
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials"))
                    .message("User not found").status(HttpStatus.NOT_FOUND).build();
        }
        LoginSuccesDTO response;
        String role=user.getClass().getSimpleName().toUpperCase();
        if(role.equals("EMPLOYEE")){
            response=LoginSuccesDTO.builder().id(user.getId()).role(role).build();
        }else if(role.equals("CUSTOMER")){
            response=LoginSuccesDTO.builder().id(user.getId()).role(role).build();
        }else if(role.equals("ADMIN")){
            response=LoginSuccesDTO.builder().id(user.getId()).role(role).build();
        }else
        {
            response=LoginSuccesDTO.builder().role(role).build();
        }


        if(passwordEncoder.matches(dto.getPassword(),user.getPassword())){
            hm.put(user.getId(),1);
            return response;
        }

        throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials"))
                .message("User not found").status(HttpStatus.NOT_FOUND).build();

    }

    @Override
    public boolean logout(String dto) {

        hm.replace(Long.parseLong(dto),1,-1);


        return true;
    }

    @Override
    public int findNrOfUsers() {
        int nr=0;
        for (Map.Entry<Long, Integer> entry : hm.entrySet()) {
            if(entry.getValue()!=-1)
                nr++;
        }

        nr--;
        return nr;
    }
}
