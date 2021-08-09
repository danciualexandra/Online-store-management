package com.proiect_PS.resurse.utils.initialization;

import com.proiect_PS.resurse.repository.AdminRepository;
import com.proiect_PS.resurse.repository.CustomerRepository;
import com.proiect_PS.resurse.repository.DiscountRepository;
import com.proiect_PS.resurse.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {

    @Autowired
    private MockDataRepo mockDataRepo;

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private DiscountRepository discountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @Bean
    public void initializeData(){

        adminRepository.save(mockDataRepo.initAdmin());
        discountRepository.saveAll(mockDataRepo.initVouchers());
        customerRepository.saveAll(mockDataRepo.initCustomers());
        employeeRepository.saveAll(mockDataRepo.initEmployee());


    }
}
