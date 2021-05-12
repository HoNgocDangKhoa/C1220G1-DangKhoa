package com.example.blog_extend.repository;


import com.example.blog_extend.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
//    Page<Blog> findByTitleContaining(Pageable pageable,String keyword);
@Query("select b from Blog b where concat(b.title,b.context,b.category.name) like %?1%")
Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByOrderByRegistrationDateAsc(Pageable pageable);

}
