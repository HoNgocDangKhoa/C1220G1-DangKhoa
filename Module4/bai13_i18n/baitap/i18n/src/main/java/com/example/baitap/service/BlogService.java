package com.example.baitap.service;

import com.example.baitap.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BlogService {
    List<Blog> findAll(Integer number);
    List<Blog> findAllByCategoryId(Long id);

    List<Blog> findAll();

    void save(Blog blog);

    void remove(Long id);

    Blog findById(Long id);
    Page<Blog> search(String name, Pageable pageable);
    List<Blog> searchBlog(String name);

}
