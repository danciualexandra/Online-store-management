package com.proiect_PS.resurse.repository;

import com.proiect_PS.resurse.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Orders,Long> {
}
