package com.example.baitap.service.Impl;

import com.example.baitap.model.Product;
import com.example.baitap.repository.ProductRepository;
import com.example.baitap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByNameProductContaining(Pageable pageable,String search) {
        return productRepository.findAllByNameProductContaining(pageable,search);
    }
}
