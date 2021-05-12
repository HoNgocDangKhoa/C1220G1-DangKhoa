package com.example.repositori;

import com.example.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void saveCustomer(Customer customer);

    void updateCustomer(int id,Customer customer);

    Customer findById(int id);

    void remove(int id);

}
