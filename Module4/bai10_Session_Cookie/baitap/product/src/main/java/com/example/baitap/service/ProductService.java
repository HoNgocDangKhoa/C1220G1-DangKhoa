package com.example.baitap.service;

import com.example.baitap.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    void save (Product product);

    void remove(Integer id);

    Product findById(Integer id);
}
