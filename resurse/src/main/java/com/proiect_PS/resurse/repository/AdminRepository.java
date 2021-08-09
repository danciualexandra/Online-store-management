package com.proiect_PS.resurse.repository;

import com.proiect_PS.resurse.model.Admin;
import com.proiect_PS.resurse.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {
 Iterable<Admin> findAll();
 Admin save(Admin admin);
 Admin findFirstByUserName(String username);
 Admin findFirstByPassword(String password);
 Admin findFirstByUserNameAndPassword(String username,String password);

}
