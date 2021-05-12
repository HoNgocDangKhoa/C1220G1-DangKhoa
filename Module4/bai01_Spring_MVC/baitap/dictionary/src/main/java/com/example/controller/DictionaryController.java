package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    @GetMapping("/")
    public String showForm(){
        return "index";
    }
    @PostMapping("search")
    public String searchDictionary(@RequestParam String search, Model model){
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("hello","xin chao");
        stringMap.put("convert","chuyen doi");
        stringMap.put("age","tuoi");
        stringMap.put("music","am nhac");
        String result = stringMap.get(search);
        model.addAttribute("search",search);
        if(result != null){
            model.addAttribute("result",result);
            return "search";
        }else {
            model.addAttribute("mess","not found");
            return "index";
        }

    }
}
