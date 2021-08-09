package com.proiect_PS.resurse.repository;

import com.proiect_PS.resurse.model.Admin;
import com.proiect_PS.resurse.model.Employee;
import com.proiect_PS.resurse.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    @Override
    Iterable<Employee> findAll();
    Employee findFirstByUserName(String username);
    Employee findFirstByPassword(String password);
    Employee findFirstByUserNameAndPassword(String username, String password);
    void delete(Employee employee);
    Employee findFirstById(Long id);

}
