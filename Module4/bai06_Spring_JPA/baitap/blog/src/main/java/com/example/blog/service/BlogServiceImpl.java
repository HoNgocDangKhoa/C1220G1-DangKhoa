package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(long id) {
        return blogRepository.findById(id).orElse(null);
    }
}
