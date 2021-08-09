package com.proiect_PS.resurse.controller;

import com.itextpdf.text.DocumentException;
import com.proiect_PS.resurse.dto.CartCredentialsDTO;
import com.proiect_PS.resurse.dto.EmployeeDetailsDTO;
import com.proiect_PS.resurse.dto.ProductCredentialsDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.model.Product;
import com.proiect_PS.resurse.service.EmployeeService;
import com.proiect_PS.resurse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;


@RestController

@CrossOrigin(origins = "http://localhost:4200")



public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
        public ResponseEntity getAllProducts(){
       return  ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());

    }

  @GetMapping("/find")
   public ResponseEntity findProductByName(@RequestParam  String productName) throws ApiExceptionResponse {
       return ResponseEntity.status(HttpStatus.OK).body(productService.findProductByProductName(productName));

    }
   @PostMapping("/admin-home/create-product")
    public ResponseEntity addProductReq(@RequestBody @Valid ProductCredentialsDTO dto) throws ApiExceptionResponse{
       return ResponseEntity.status(HttpStatus.OK).body(productService.addProduct(dto));
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }
    @PutMapping("/admin-home/update-product/{id}")
    public ResponseEntity updateProductReq(@PathVariable Long id,@RequestBody @Valid ProductCredentialsDTO dto)throws ApiExceptionResponse{
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id,dto));
    }
    @PutMapping("/customer-home/{id}")
   public ResponseEntity updateStock(@RequestBody @Valid CartCredentialsDTO dto) throws ApiExceptionResponse, IOException, DocumentException {
      return ResponseEntity.status(HttpStatus.OK).body(productService.updateStockAfterPayment(dto));

  }
    @GetMapping("/export/{id}")
    public ResponseEntity exportProductDetails(@PathVariable Long id, @RequestParam String fileType){
        return ResponseEntity.ok(productService.exportProductDetails(id,fileType));
    }



}
