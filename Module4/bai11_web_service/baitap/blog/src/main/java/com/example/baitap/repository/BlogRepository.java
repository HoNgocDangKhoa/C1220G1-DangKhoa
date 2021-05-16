package com.example.baitap.repository;


import com.example.baitap.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAll();

    List<Blog> findAllByCategoryId(Long id);
}
