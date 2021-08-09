package com.proiect_PS.resurse.repository;

import com.proiect_PS.resurse.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
 User findFirstById(Long id);
   User findFirstByUserName(String username);
   User findFirstByPassword(String password);



}
