package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("list", "customerList", customerService.findAll());
    }

    @GetMapping("edit")
    public String showFormEdit(@RequestParam int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("edit", customer);
        return "update";
    }

    @PostMapping("update")
    public String saveCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("save")
    public String showForm(Model model) {
        model.addAttribute("saveCustomer", new Customer());
        return "save";
    }
    @PostMapping("add")
    public String save(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/";
    }
    @GetMapping("view")
    public String showView(@RequestParam int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("showView", customer);
        return "view";
    }
    @PostMapping("delete")
    public String delete(@RequestParam int id,Model model){
    customerService.removeCustomer(id);
    model.addAttribute("succes","deleted successfully");
    return "redirect:/";
    }

}
