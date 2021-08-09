package com.proiect_PS.resurse.repository;

import com.proiect_PS.resurse.model.Account;
import com.proiect_PS.resurse.model.Admin;
import com.proiect_PS.resurse.model.Customer;
import com.proiect_PS.resurse.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository <Customer,Long> {
    Customer findFirstByUserName(String username);
   Customer findFirstByPassword(String password);
   Customer findFirstByFirstName(String firstName);
   Customer findFirstByLastName(String lastName);
    Iterable<Customer> findAll();
    Customer findFirstByUserNameAndPassword(String username,String password);
   void delete(Customer c);
    Customer save(Customer customer);
    Customer findFirstById(Long id);


}
