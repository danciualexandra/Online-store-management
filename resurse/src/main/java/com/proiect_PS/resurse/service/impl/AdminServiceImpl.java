package com.proiect_PS.resurse.service.impl;

import com.proiect_PS.resurse.model.Admin;
import com.proiect_PS.resurse.model.Product;
import com.proiect_PS.resurse.repository.AdminRepository;
import com.proiect_PS.resurse.repository.CustomerRepository;
import com.proiect_PS.resurse.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> findAllAdmins(){
        return (List<Admin>) adminRepository.findAll();
    }
    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }

    @Override
    public Admin findUserName(String username) {
        return adminRepository.findFirstByUserName(username);
    }

    @Override
    public Admin findPassword(String password) {
        return adminRepository.findFirstByPassword(password);
    }

    @Override
    public Admin findUsernameAndPassword(String username, String password) {
        return adminRepository.findFirstByUserNameAndPassword(username,password);
    }
}
