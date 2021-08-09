package com.proiect_PS.resurse.service.impl;

import com.proiect_PS.resurse.model.User;
import com.proiect_PS.resurse.repository.UserRepository;
import com.proiect_PS.resurse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(Long id) {

        return userRepository.findById(id);
    }
    public User findUserName(String username){
        return userRepository.findFirstByUserName(username);
    }
    public User findPassword(String password){
        return userRepository.findFirstByPassword(password);
    }


}
