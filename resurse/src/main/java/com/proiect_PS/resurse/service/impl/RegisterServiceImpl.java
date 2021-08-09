package com.proiect_PS.resurse.service.impl;

import com.proiect_PS.resurse.dto.RegisterCredentialsDTO;
import com.proiect_PS.resurse.dto.RegisterSuccesDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.model.Customer;
import com.proiect_PS.resurse.model.DiscountVoucher;
import com.proiect_PS.resurse.repository.CustomerRepository;
import com.proiect_PS.resurse.repository.DiscountRepository;
import com.proiect_PS.resurse.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public RegisterSuccesDTO register(RegisterCredentialsDTO dto) throws ApiExceptionResponse {
        String userName=dto.getUserName();
        String firstName=dto.getFirstName();
        String password=dto.getPassword();
        String lastName=dto.getLastName();
        String email=dto.getEmail();
        String address=dto.getAddress();
        String phone=dto.getPhone();
        String gender=dto.getGender();
        Integer zipCode=dto.getZipCode();


        RegisterSuccesDTO response;
        List<DiscountVoucher> discountVouchers= (List<DiscountVoucher>) discountRepository.findAll();


        response=RegisterSuccesDTO.builder().firstName(firstName).lastName(lastName).userName(userName).password(passwordEncoder.encode(password)).email(email).address(address).phone(phone).gender(gender).zipCode(zipCode).build();
        Customer c= new Customer();




        Customer customer=Customer.builder().userName(userName).firstName(firstName).lastName(lastName).address(address).zipcode(zipCode).phone(phone).gender(gender).password(passwordEncoder.encode(password)).email(email).build();


       customerRepository.save(customer);

        return response;
    }
}
