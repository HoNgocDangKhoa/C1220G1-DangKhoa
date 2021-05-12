package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController {
    @GetMapping("/")
    public ModelAndView showForm(){
        return new ModelAndView("index","employee", new Employee()) ;
    }
    @PostMapping("addEmployee")
    public String saveEmployee(@ModelAttribute Employee employee, BindingResult result,Model model){
        model.addAttribute("name",employee.getName());
        model.addAttribute("id",employee.getId());
        model.addAttribute("contact",employee.getContactNumber());
        return "save";
    }
}
