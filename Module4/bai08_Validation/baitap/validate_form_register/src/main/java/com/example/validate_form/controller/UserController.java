package com.example.validate_form.controller;

import com.example.validate_form.model.User;
import com.example.validate_form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public ModelAndView getForm(){
        return new ModelAndView("index","user",new User());
    }
    @PostMapping("/validateForm")
    public String save(@Validated User user, BindingResult bindingResult, Model model){
     new User().validate(user,bindingResult);
     if(bindingResult.hasErrors()){
         model.addAttribute("user",user);
         return "index";
     } else {
         userService.save(user);
         model.addAttribute("user",user);
        return "result";
     }
    }
}
