package com.proiect_PS.resurse.controller;

import com.proiect_PS.resurse.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/orders")
    public ResponseEntity getAllProducts(){
        return  ResponseEntity.status(HttpStatus.OK).body(ordersService.getAllOrders());

    }
}
