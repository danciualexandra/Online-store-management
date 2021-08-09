package com.proiect_PS.resurse.controller;

import com.proiect_PS.resurse.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin(origins = "http://localhost:4200")


public class DiscountController {

    @Autowired
    private DiscountService discountService;
    @GetMapping("/vouchers")
    public ResponseEntity getAllVouchers(){
        return  ResponseEntity.status(HttpStatus.OK).body(discountService.getAllVouchers());

    }
}
