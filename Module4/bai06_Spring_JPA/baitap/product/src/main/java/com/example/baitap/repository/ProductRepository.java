package com.example.baitap.repository;

import com.example.baitap.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product>findAll(Pageable pageable);
    @Query(value = "select * from product" +
            " where concat(name_product,price_product,amount_product)" +
            " like %?1%",nativeQuery = true)
    Page<Product>findAllByNameProductContaining(Pageable pageable , String search);
}
