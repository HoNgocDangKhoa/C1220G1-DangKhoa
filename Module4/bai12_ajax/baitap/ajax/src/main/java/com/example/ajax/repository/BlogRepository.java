package com.example.ajax.repository;


import com.example.ajax.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select * from blog limit  ?",nativeQuery = true)

    List<Blog> findAll(Integer number);

    List<Blog> findAllByCategoryId(Long id);

    @Query(value = "select * from Blog  where concat(title,`context`) like %?1% ", nativeQuery = true)
    List<Blog> findAllByTitleContaining(String title);
}
