package com.example.baitap.service;

import com.example.baitap.model.Detail;

import java.util.List;
import java.util.Optional;

public interface DetailService  {
    Detail findById(Integer id);

    List<Detail> findAll();
}
