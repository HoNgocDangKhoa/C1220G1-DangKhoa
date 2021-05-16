package com.example.baitap.controller;

import com.example.baitap.entity.Blog;
import com.example.baitap.entity.Category;
import com.example.baitap.service.BlogService;
import com.example.baitap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> listBlog() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Blog>>(blogList, HttpStatus.OK);
        }
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable Long id){
        Blog blog= blogService.findById(id);
        if(blog==null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Blog>(blog,HttpStatus.OK);
        }
    }

    @PostMapping("/blog/create")
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog) {
        blogService.save(blog);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> listCategory() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
        }
    }
}
