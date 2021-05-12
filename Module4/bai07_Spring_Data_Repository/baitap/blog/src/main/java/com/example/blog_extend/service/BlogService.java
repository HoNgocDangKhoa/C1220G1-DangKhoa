package com.example.blog_extend.service;


import com.example.blog_extend.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    void remove(Long id);

    Blog findById(Long id);
//    Page<Blog> findByTitleContaining(String keyword,Pageable pageable);
Page<Blog> search(String name,Pageable pageable);

Page<Blog> sort(Pageable pageable);
}
