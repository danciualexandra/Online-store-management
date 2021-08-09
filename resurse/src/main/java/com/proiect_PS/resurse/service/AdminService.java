package com.proiect_PS.resurse.service;

import com.proiect_PS.resurse.model.Admin;
import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.model.Product;
import com.proiect_PS.resurse.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminService {
    List<Admin> findAllAdmins();
   Admin save(Admin admin);
    Admin findUserName(String username);
    Admin findPassword(String password);
    Admin findUsernameAndPassword(String username,String password);
}
