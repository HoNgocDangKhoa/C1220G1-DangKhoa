package com.example.ajax.service;

import com.example.ajax.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CategoryService {
    Page<Category> findAll(Pageable pageable);
    List<Category> findAll();

    void saveCategory(Category category);

    void deleteCategory(Long id);

   Category findById(Long id);

}
