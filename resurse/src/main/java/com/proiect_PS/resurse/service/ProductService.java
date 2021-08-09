package com.proiect_PS.resurse.service;

import com.itextpdf.text.DocumentException;
import com.proiect_PS.resurse.dto.*;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.model.Product;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public interface ProductService {
  Iterable<Product> getAllProducts();

   Product saveProduct(Product product);
   void saveProducts(List<Product> products);
   Optional<Product> findProductById(long id);



 Product findProductByProductName(String product) throws ApiExceptionResponse;
    void deleteProductName(String name);
 void delete(Product product);
 Product deleteProduct(Long id);
    ProductSuccesDTO addProduct(ProductCredentialsDTO dto) throws ApiExceptionResponse;
    Product updateProduct(Long id, ProductCredentialsDTO dto) throws ApiExceptionResponse;
    boolean updateStockAfterPayment(CartCredentialsDTO dto) throws IOException, DocumentException, ApiExceptionResponse;

    String exportProductDetails(Long id, String fileType);
}
