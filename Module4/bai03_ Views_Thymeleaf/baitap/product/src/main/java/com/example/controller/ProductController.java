package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String showAllProduct(Model model) {
        model.addAttribute("show", productService.findAll());
        return "index";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("createProduct", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String saveProduct(Product product) {
        product.setId((int) (Math.random() * 100));
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("edit")
    public String showFormEdit(@RequestParam int id, Model model) {
        model.addAttribute("editProduct", productService.findById(id));
        return "edit";
    }

    @PostMapping("update")
    public String editProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("view")
    public String showView(@RequestParam int id, Model model) {
        model.addAttribute("showView", productService.findById(id));
        return "view";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("success", "Delete product successfully");
        return "redirect:/";
    }
}
