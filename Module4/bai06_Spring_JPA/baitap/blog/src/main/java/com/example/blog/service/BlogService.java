package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();

    void save(Blog blog);

    void remove(long id);

    Blog findById(long id);

}
