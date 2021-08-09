package com.proiect_PS.resurse.service.impl;

import com.itextpdf.text.DocumentException;
import com.proiect_PS.resurse.constants.FileType;
import com.proiect_PS.resurse.constants.NotificationEndpoints;
import com.proiect_PS.resurse.dto.CartCredentialsDTO;
import com.proiect_PS.resurse.dto.ProductCredentialsDTO;
import com.proiect_PS.resurse.dto.ProductSuccesDTO;
import com.proiect_PS.resurse.exception.ApiExceptionResponse;
import com.proiect_PS.resurse.factory.EmailSender;
import com.proiect_PS.resurse.model.*;
import com.proiect_PS.resurse.repository.CustomerRepository;
import com.proiect_PS.resurse.repository.DiscountRepository;
import com.proiect_PS.resurse.repository.OrderRepository;
import com.proiect_PS.resurse.repository.ProductRepository;

import com.proiect_PS.resurse.service.DiscountService;
import com.proiect_PS.resurse.service.ProductService;
import com.proiect_PS.resurse.utils.exporter.FileExporter;
import com.proiect_PS.resurse.utils.exporter.TXTFileExporter;
import com.proiect_PS.resurse.utils.exporter.XMLFileExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private DiscountRepository discountRepository;




    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }
    public Product saveProduct(Product product){
      return productRepository.save(product);
    }

    public Optional<Product> findProductById(long id){
        return productRepository.findById(id);
    }



    public void saveProducts(List<Product> products){
        productRepository.saveAll(products);
    }


    public void deleteProductName(String name){
        productRepository.deleteByProductName(name);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product deleteProduct(Long id) {

                Product product=productRepository.findFirstById(id);
                productRepository.delete(product);
                return product;

    }

    @Override
    public ProductSuccesDTO addProduct(ProductCredentialsDTO dto) throws ApiExceptionResponse {
        String productName=dto.getProductName();
        double productPrice=dto.getProductPrice();
        Integer quantity=dto.getQuantity();
        LocalDateTime manufacturing=dto.getManufacturing();
        LocalDateTime expiration=dto.getExpiration();
        double shipDeliveryPrice=dto.getShipDeliveryPrice();
        String companyName=dto.getCompanyName();



        ProductSuccesDTO response;


        response=ProductSuccesDTO.builder().productName(productName).build();
        Product product=new Product();

       product.setProductName(productName);
       product.setProductPrice(productPrice);
       product.setQuantity(quantity);
        product.setManufacturing(manufacturing);
       product.setExpiration(expiration);
        product.setShipDeliveryPrice(shipDeliveryPrice);
        product.setCompanyName(companyName);

        productRepository.save(product);

        return response;



    }

    @Override
    public Product updateProduct(Long id, ProductCredentialsDTO dto) throws ApiExceptionResponse {
        String productName=dto.getProductName();
        double productPrice=dto.getProductPrice();
        Integer quantity=dto.getQuantity();
        LocalDateTime manufacturing=dto.getManufacturing();
        LocalDateTime expiration=dto.getExpiration();
        double shipDeliveryPrice=dto.getShipDeliveryPrice();
        String companyName=dto.getCompanyName();
        ProductSuccesDTO response;
        Product product=productRepository.findFirstById(id);
        if(product==null) {

            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials"))
                    .message("Product doesn't exists").status(HttpStatus.NOT_FOUND).build();

        }
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setQuantity(quantity);
        product.setManufacturing(manufacturing);
        product.setExpiration(expiration);
        product.setShipDeliveryPrice(shipDeliveryPrice);
        product.setCompanyName(companyName);

        return productRepository.save(product);

    }

    @Override
    public boolean updateStockAfterPayment(CartCredentialsDTO dto) throws IOException, DocumentException, ApiExceptionResponse {


        Long customerId=dto.getId();
        String voucher="";
        List<String> productsName=new ArrayList<String>();
        Customer customer=customerRepository.findFirstById(customerId);
        if(dto.getIban()!=null) {
            Account account = new Account();
            account.setIBAN(dto.getIban());
            customer.setAccount(account);
            customerRepository.save(customer);
        }
        if(dto.getIban()==null) {

            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials"))
                    .message("Iban doesn't exist.Maybe the payment was done with cash").status(HttpStatus.NOT_FOUND).build();

        }
        if(dto.getVoucher()==null){
            throw ApiExceptionResponse.builder().errors(Collections.singletonList("Bad credentials"))
                    .message("Voucher doesn't exist").status(HttpStatus.NOT_FOUND).build();

        }else{
            voucher=dto.getVoucher();

        }

       List<Product> chosenProducts=new ArrayList<Product>();

        for(int i=0;i<dto.getIdProductsFromCart().size();i++){
            Long id=Long.parseLong(dto.getIdProductsFromCart().get(i));
            Product product=productRepository.findFirstById(id);
            productsName.add(product.getProductName());
            chosenProducts.add(product);


            product.setQuantity(product.getQuantity()-1);
            productRepository.save(product);

        }


        Orders order=new Orders();

        String [] correctSum=dto.getSum().split("\\.");

        Long total=Long.parseLong(correctSum[0]);
        order.setTotalSum(total);
        Customer actualCustomer=new Customer();
        actualCustomer.setId(customer.getId());
        actualCustomer.setFirstName(customer.getFirstName());
        actualCustomer.setLastName(customer.getLastName());
        actualCustomer.setZipcode(customer.getZipcode());
        actualCustomer.setAddress(customer.getAddress());
        actualCustomer.setProducts(chosenProducts);

        order.setCustomer(actualCustomer);

       customerRepository.save(customer);

        orderRepository.save(order);

        this.template.convertAndSend(NotificationEndpoints.ADMIN_RECEIVE_COMMAND,"Order is processing");

        EmailSender emailSender=new EmailSender();
        emailSender.sendEmail("testconfirmation789@gmail.com",order);

        return true;
    }

    @Override
    public String exportProductDetails(Long id, String fileType) {

           Product product=productRepository.findFirstById(id);

            FileExporter fileExporter;
            if(fileType.equals(FileType.XML)){
                fileExporter=new XMLFileExporter();
                return fileExporter.exportData(product);
            }
            else if(fileType.equals(FileType.TXT)){
                fileExporter=new TXTFileExporter();
                return fileExporter.exportData(product);
            }
            return null;

    }


    public Product findProductByProductName(String product) throws ApiExceptionResponse{
         Product product1=productRepository.findProductByProductName(product);
         if(product1==null){
             throw ApiExceptionResponse.builder().errors(Collections.singletonList("There is no product with name "+product ))
                     .message("Entity not found").status(HttpStatus.NOT_FOUND).build();
         }
         return product1;

    }





}
