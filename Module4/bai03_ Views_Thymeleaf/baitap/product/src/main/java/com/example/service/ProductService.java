package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void saveProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);

    Product findById(int id);
}
