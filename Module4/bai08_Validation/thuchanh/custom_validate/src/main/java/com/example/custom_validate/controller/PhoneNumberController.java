package com.example.custom_validate.controller;

import com.example.custom_validate.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneNumberController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "index";
    }
    @PostMapping("/validate")
    public String customValidate(@Validated PhoneNumber phoneNumber, BindingResult bindingResult ,Model model){
    new PhoneNumber().validate(phoneNumber,bindingResult);
    if(bindingResult.hasErrors()){
        return "index";
    }else {
        model.addAttribute("phoneNumber",phoneNumber.getNumber());
        return "result";
    }
    }
}
