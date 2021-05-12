package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String showFindAll(Model model) {
        model.addAttribute("customerList", customerService.findAll());
        return "index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("addCustomer", new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String saveCustomer(Customer customer) {
        customer.setId((int) (Math.random() * 1000));
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showFormEdit(Customer customer, Model model) {
        model.addAttribute("editCustomer", customerService.findById(customer.getId()));
        return "edit";
    }

    @PostMapping("/customer/update")
    public String addNewCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/";
    }
  @GetMapping("/delete")
    public String showFormDelete(Customer customer,Model model){
        model.addAttribute("deleteCus",customerService.findById(customer.getId()));
        return "delete";
    }
    @PostMapping ("/deletes")
    public String deleteCustomer(Customer customer){
        customerService.remove(customer.getId());
        return "redirect:/";
    }
    @GetMapping("/view")
    public String viewCustomer(Customer customer,Model model){
        model.addAttribute("viewCus",customerService.findById(customer.getId()));
        return "view";
    }

}