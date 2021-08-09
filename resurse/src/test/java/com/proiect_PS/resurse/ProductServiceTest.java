package com.proiect_PS.resurse;


import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.model.Product;
import com.proiect_PS.resurse.service.EmployeeService;
import com.proiect_PS.resurse.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;


   /* @Test
   public void testAddProduct(){
        LocalDateTime manufacturing1=LocalDateTime.of(2021,8,5,3,10);
        LocalDateTime expiration1=LocalDateTime.of(2022,4,2,3,10);
        Product product1=new Product();
        product1.setProductName("");
        product1.setProductPrice(89.9);
       product1.setManufacturing(manufacturing1);
        product1.setExpiration(expiration1);
        product1.setCompanyName("Vichy_Laboratories");
       product1.setQuantity(20);
        productService.saveProduct(product1);
        Assertions.assertTrue(product1.getId()!=null);
    }
*/


}
