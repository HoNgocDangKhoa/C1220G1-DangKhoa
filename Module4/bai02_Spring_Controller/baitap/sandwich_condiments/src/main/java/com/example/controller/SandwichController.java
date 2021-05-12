package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

   @PostMapping("/sandwich")
    public String save(Model model, @RequestParam("condiment") String [] condiments) {
         model.addAttribute("listCondiment",condiments);
         return "index";
    }
//    @RequestMapping("/sandwich")
//    public String save(Model model, @RequestParam ("condiment" )String [] condiment) {
//        model.addAttribute("condiment", Arrays.toString(condiment));
//        return "index";
//    }
}
