package com.example.baitap.service;

import com.example.baitap.model.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(long id);
}
