package com.example.ajax.service;


import com.example.ajax.entity.Blog;
import com.example.ajax.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;



    @Override
    public List<Blog> findAll(Integer number) {
        return blogRepository.findAll(number);
    }

    @Override
    public List<Blog> findAllByCategoryId(Long id) {
        return blogRepository.findAllByCategoryId(id);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }


    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return null;
    }

    @Override
    public List<Blog> searchBlog(String name) {
        return blogRepository.findAllByTitleContaining(name);
    }


}
