package com.example.baitap.service;

import com.example.baitap.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Product findById(Integer id);

    void save(Product product);

    void remove(Integer id);
    Page<Product>findAllByNameProductContaining(Pageable pageable,String search);
}
