package com.proiect_PS.resurse.repository;


import com.proiect_PS.resurse.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

    Product findFirstById(Long id);
    @Override
    Iterable<Product> findAll();

    void deleteById(long id);
    void deleteByProductName(String product);

    Product findProductByProductName(String product);
    void delete(Product product);
}
