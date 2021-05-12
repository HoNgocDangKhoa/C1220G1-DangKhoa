package com.example.controller;

import com.example.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputerController {
    @Autowired
    ComputerService computerService;
    @GetMapping("/")
    public String getForm(){
        return "index";
    }
    @PostMapping("computer")
    public String calculation(Model model,@RequestParam int first,@RequestParam int second,@RequestParam String calculation){
        int result = computerService.calculation(first,second,calculation);
        model.addAttribute("first",first);
        model.addAttribute("second",second);
        model.addAttribute("calculation",calculation);
        model.addAttribute("result",result);
        return "index";
    }

}
