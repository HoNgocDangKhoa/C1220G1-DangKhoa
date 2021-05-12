package com.example.baitap.service.Impl;

import com.example.baitap.model.Detail;
import com.example.baitap.repository.DetailRepository;
import com.example.baitap.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    DetailRepository detailRepository;
    @Override
    public Detail findById(Integer id) {
        return detailRepository.findById(id).orElse(null);
    }

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }
}
