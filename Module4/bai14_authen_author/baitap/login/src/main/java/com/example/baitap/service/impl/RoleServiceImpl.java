package com.example.baitap.service.impl;

import com.example.baitap.service.RoleService;
import com.example.baitap.model.Role;
import com.example.baitap.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
