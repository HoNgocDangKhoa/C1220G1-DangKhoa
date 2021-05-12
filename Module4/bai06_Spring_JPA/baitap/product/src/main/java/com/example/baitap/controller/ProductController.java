package com.example.baitap.controller;

import com.example.baitap.model.Product;
import com.example.baitap.service.DetailService;
import com.example.baitap.service.DirectoryService;
import com.example.baitap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    DirectoryService directoryService;
    @Autowired
    DetailService detailService;
    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable){
        return new ModelAndView("list","product",productService.findAll(pageable));
    }
    @GetMapping("create")
    public String showForm(Model model, Product product){
        model.addAttribute("product",product);
        model.addAttribute("directory",directoryService.findAll());
        model.addAttribute("detail",detailService.findAll());
        return "create";
    }
    @PostMapping("create")
    public String create(@ModelAttribute(name="product") Product product){
        productService.save(product);
        return "redirect:/";
    }
    @GetMapping("edit")
    public String getForm(@RequestParam(name="id")Integer id,Model model){
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("directory",directoryService.findAll());
        return "edit";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute(name="product")Product product){
        productService.save(product);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id){
        productService.remove(id);
        return "redirect:/";
    }
    @GetMapping("view")
    public String view(@RequestParam(name="id")Integer id,Model model){
        model.addAttribute("detail",detailService.findAll());
        model.addAttribute("product",productService.findById(id));
       return "view";
    }
    @GetMapping("search")
    public String search(@RequestParam(name="search")String search,Pageable pageable,Model model){
        if(search.equals(" ")){
            model.addAttribute("product",productService.findAll(pageable));
            return "redirect:/";
        }else {
            model.addAttribute("product",productService.findAllByNameProductContaining(pageable,search));
            return "list";
        }
    }
}
