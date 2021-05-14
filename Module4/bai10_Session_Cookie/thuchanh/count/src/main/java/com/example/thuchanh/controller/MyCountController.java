package com.example.thuchanh.controller;

import com.example.thuchanh.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("myCounter")
public class MyCountController {

    /* add MyCounter in model attribute */
    @ModelAttribute("myCounter")
    public MyCounter setUpCounter(){
        return new MyCounter();
    }
    @GetMapping("")
    public String get(@ModelAttribute(name="myCounter") MyCounter myCounter){
        myCounter.increment();
        return "count";
    }
 }
