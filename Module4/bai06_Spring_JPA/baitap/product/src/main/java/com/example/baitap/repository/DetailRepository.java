package com.example.baitap.repository;

import com.example.baitap.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer> {
    @Query(value = "SELECT detail.`context`,detail.producer,product.id_product,product.name_product,product.price_product FROM detail\n" +
            "inner join product \n" +
            "on detail.id_detail=product.id_detail\n" +
            "where product.id_product like %?1%",nativeQuery = true)
    Optional<Detail> findById(Integer id);
}
