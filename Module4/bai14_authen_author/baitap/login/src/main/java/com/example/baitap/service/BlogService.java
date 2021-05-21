package com.example.baitap.service;


import com.example.baitap.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    void remove(Long id);

    Blog findById(Long id);

Page<Blog> search(String name, Pageable pageable);

Page<Blog> sort(Pageable pageable);
}
