package com.proiect_PS.resurse;

import com.proiect_PS.resurse.model.*;
import com.proiect_PS.resurse.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class ResurseApplication {


	public static void main(String[] args) {
		SpringApplication.run(ResurseApplication.class, args);
	}



	@Bean
	CommandLineRunner init(ProductRepository productRepository, EmployeeRepository employeeRepository, UserRepository userRepository, CustomerRepository customerRepository, AdminRepository adminRepository, OrderRepository orderRepository){
		return args->{

			LocalDateTime manufacturing1=LocalDateTime.of(2021,2,5,4,5);
			LocalDateTime manufacturing2=LocalDateTime.of(2021,4,2,3,10);
			LocalDateTime expiration1=LocalDateTime.of(2022,4,2,3,10);
			LocalDateTime expiration2=LocalDateTime.of(2023,4,2,3,10);
			Product product1=new Product();
			product1.setProductName("Vichy_Mineral_89");
			product1.setProductPrice(89.9);
			product1.setShipDeliveryPrice(13.9);
			product1.setManufacturing(manufacturing1);
			product1.setExpiration(expiration1);
			product1.setCompanyName("Vichy_Laboratories");
			product1.setQuantity(20);


			Product product2=new Product();
			product2.setProductName("The_Ordinary_caffeine_solution");
			product2.setProductPrice(37);
			product2.setShipDeliveryPrice(9.9);
			product2.setManufacturing(manufacturing2);
			product2.setExpiration(expiration2);
			product2.setCompanyName("The_ordinary");
			product2.setQuantity(85);

			Product product3=new Product();
			product3.setProductName("Coconut oil");
			product3.setProductPrice(25);
			product3.setShipDeliveryPrice(5.9);
			LocalDateTime expiration3=LocalDateTime.of(2022,1,5,2,5);
			LocalDateTime manufacturing3=LocalDateTime.of(2019,3,5,4,5);
			product3.setManufacturing(manufacturing3);
			product3.setExpiration(expiration3);
			product3.setCompanyName("Raw Boost");
			product3.setQuantity(35);


			//Product product1=new Product(null,"Vichy_Mineral_89",89.9,3,manufacturing1,expiration1,15.5,"Vichy_Laboratories");
			//Product product2=new Product(null,"The_Ordinary_caffeine_solution",37,10,manufacturing2,expiration2,7.5,"The_ordinary");
			ArrayList<Product> stockProducts=new ArrayList<>();
			stockProducts.add(product1);
			stockProducts.add(product2);
			stockProducts.add(product3);


			ArrayList<Product> savedProducts= (ArrayList<Product>) productRepository.saveAll(stockProducts);





		};

	}

}
