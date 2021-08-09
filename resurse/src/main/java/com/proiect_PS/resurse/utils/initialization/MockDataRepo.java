package com.proiect_PS.resurse.utils.initialization;

import com.proiect_PS.resurse.model.Admin;
import com.proiect_PS.resurse.model.Customer;
import com.proiect_PS.resurse.model.DiscountVoucher;
import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class MockDataRepo {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private DiscountRepository discountRepository;

    public Admin initAdmin(){
        return Admin.builder().userName("admin").gender("m").phone("0711223344").firstName("Cristian").lastName("Pop").address("Cluj-Napoca").email("pop@admin.com").salary(6000.0).password(encoder.encode("admin")).build();
    }
    public List<DiscountVoucher> initVouchers(){
        List<DiscountVoucher> vouchers=new LinkedList<>();
        vouchers.add(DiscountVoucher.builder().voucherCode("PROMO20").build());
        vouchers.add(DiscountVoucher.builder().voucherCode("PROMO30").build());
        vouchers.add(DiscountVoucher.builder().voucherCode("PROMO40").build());


        return vouchers;
    }
    public List<Customer> initCustomers(){


        List<Customer> customers=new LinkedList<>();
        List<DiscountVoucher>discountVouchers= (List<DiscountVoucher>) discountRepository.findAll();
       Customer customer=Customer.builder().userName("andrada").password(encoder.encode("andrada")).
               firstName("andrada").lastName("Dan").email("andrada@yahoo.com").address("Oradea").phone("0762228222"). gender("f").zipcode(540678).build();
      
        customers.add(customer);
        return customers;
    }
    public List<Employee> initEmployee(){

        List<Employee> employees=new LinkedList<>();

        employees.add(Employee.builder().salary(2000.0).userName("marcel").password(encoder.encode("marcel")).
                firstName("Marcel").lastName("Pop").email("marcel@yahoo.com").address("Bucuresti").phone("0722222222"). gender("m").zipCode(540257).build());

        return employees;
    }









}
