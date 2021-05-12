package com.example.aop.service;

import com.example.aop.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    Book findByBookCode(String bookCode);


}
