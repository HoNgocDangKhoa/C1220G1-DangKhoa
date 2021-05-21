package com.example.baitap.service;

import com.example.baitap.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    void saveCategory(Category category);

    void deleteCategory(Long id);

   Category findById(Long id);

}
