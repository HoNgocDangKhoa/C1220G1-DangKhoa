package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void saveCustomer(Customer customer);

    void updateCustomer(int id,Customer customer);

    Customer findById(int id);

    void remove(int id);
}
