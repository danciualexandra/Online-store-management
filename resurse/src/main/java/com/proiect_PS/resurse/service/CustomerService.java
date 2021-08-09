package com.proiect_PS.resurse.service;

import com.proiect_PS.resurse.model.Admin;
import com.proiect_PS.resurse.model.Customer;

import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService {
    Customer findUserName(String username);
   Customer findPassword(String password);
   Customer findFirstName(String firstName);
   Customer findLastName(String lastName);
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    Customer findFirstByUserNameAndPassword(String username, String password);
    void delete(Customer c);
    Customer findFirstById(Long id);
}
