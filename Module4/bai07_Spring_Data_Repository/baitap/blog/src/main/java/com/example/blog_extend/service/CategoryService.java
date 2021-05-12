package com.example.blog_extend.service;

import com.example.blog_extend.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;


public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    void saveCategory(Category category);

    void deleteCategory(Long id);

   Category findById(Long id);

}
