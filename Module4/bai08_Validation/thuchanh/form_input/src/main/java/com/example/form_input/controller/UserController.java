package com.example.form_input.controller;

import com.example.form_input.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "/index";
    }

    @PostMapping("validate")
    public String validateUser(@Validated User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/index";
        } else {
            model.addAttribute("message", "Congratulations! You are old enough to sign up for this site");
            return "/result";
        }
    }
}
