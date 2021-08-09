package com.proiect_PS.resurse.service.impl;

import com.proiect_PS.resurse.model.Admin;
import com.proiect_PS.resurse.model.Customer;
import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.repository.CustomerRepository;
import com.proiect_PS.resurse.repository.EmployeeRepository;
import com.proiect_PS.resurse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findUserName(String username){
        return customerRepository.findFirstByUserName(username);
    }
    public Customer findPassword(String password){
        return customerRepository.findFirstByPassword(password);
    }

    @Override
    public Customer findFirstName(String firstName) {
        return customerRepository.findFirstByFirstName(firstName);
    }

    @Override
    public Customer findLastName(String lastName) {
        return customerRepository.findFirstByLastName(lastName);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();

    }
   public void saveCustomer(Customer customer){
       customerRepository.save(customer);
   }

    @Override
    public Customer findFirstByUserNameAndPassword(String username, String password) {
        return customerRepository.findFirstByUserNameAndPassword(username,password);
    }

    @Override
    public void delete(Customer c) {
        customerRepository.delete(c);
    }

    @Override
    public Customer findFirstById(Long id) {
        return customerRepository.findFirstById(id);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }
}
