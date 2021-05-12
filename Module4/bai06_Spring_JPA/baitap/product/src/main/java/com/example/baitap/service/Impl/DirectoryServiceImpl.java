package com.example.baitap.service.Impl;

import com.example.baitap.model.Directory;
import com.example.baitap.repository.DirectoryRepository;
import com.example.baitap.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DirectoryServiceImpl implements DirectoryService {
    @Autowired
    DirectoryRepository directoryRepository;
    @Override
    public List<Directory> findAll() {
        return directoryRepository.findAll();
    }
}
