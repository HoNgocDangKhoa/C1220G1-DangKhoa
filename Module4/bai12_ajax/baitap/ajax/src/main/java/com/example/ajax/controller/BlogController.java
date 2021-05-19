package com.example.ajax.controller;

import com.example.ajax.entity.Blog;
import com.example.ajax.entity.Category;
import com.example.ajax.service.BlogService;
import com.example.ajax.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class BlogController {
    private Integer number=3;
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/blog")
    public String showList(Model model){
        model.addAttribute("blog",blogService.findAll(3));
        return "list";
    }
    @GetMapping("/blog/create")
    public String showForm(Model model ){
        model.addAttribute("blog",new Blog());
        model.addAttribute("category",categoryService.findAll());
        return "create";

    }
    @PostMapping("/blog/create")
    public String create(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/blog/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("category",categoryService.findAll());
        return "edit";
    }
    @PostMapping("/blog/edit")
    public String edit(@ModelAttribute (name="blog") Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("/blog/delete/{id}")
    public String showFormDelete(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("category",categoryService.findAll());
        return "delete";
    }
    @PostMapping("blog/delete/")
    public String delete(@RequestParam Long id){
        blogService.remove(id);
        return "redirect:/blog";
    }
    @GetMapping("blog/search/{keyword}")
    public String search(@PathVariable String keyword , Model model){
        if(keyword.isEmpty()){
            model.addAttribute("blog",blogService.findAll());
            return "redirect:/blog";
        }else {
            model.addAttribute("blog",blogService.searchBlog(keyword));
            return "list";
        }
    }
    @GetMapping("blog/load")
    public String load( Model model){
        number+=3;
        model.addAttribute("blog",blogService.findAll(number));
        return "list";
    }
}
