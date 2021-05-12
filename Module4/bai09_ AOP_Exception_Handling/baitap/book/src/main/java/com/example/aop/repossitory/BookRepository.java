package com.example.aop.repossitory;

import com.example.aop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByBookCode(String bookCode);
}
