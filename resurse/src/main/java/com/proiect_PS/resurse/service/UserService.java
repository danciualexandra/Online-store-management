package com.proiect_PS.resurse.service;

import com.proiect_PS.resurse.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserService {
    Optional<User> findById(Long id);
    User findUserName(String username);
    User findPassword(String password);

}

