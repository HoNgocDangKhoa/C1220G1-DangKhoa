package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("list", "product", productService.findAll());
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("view")
    public String getForm(@RequestParam Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("shopping")
    public String showListCart(@ModelAttribute("cart") Cart cart, Model model) {
        Integer totalCost = cart.getTotalCost();
        model.addAttribute("totalCost",totalCost);
        model.addAttribute("listCart", cart.getCart());
        return "list_cart";
    }

    @PostMapping("view/shopping/create")
    public String createCare(@ModelAttribute("cart") Cart cart, @RequestParam Integer id, Model model) {
        cart.saveCart(productService.findById(id));
        model.addAttribute("listCart", cart.getCart());
        return "redirect:/";
    }

    @GetMapping("shopping/edit")
    public String showFormEdit(Cart cart, @RequestParam Integer id, Model model) {
        Product product = productService.findById(id);
        Integer setAmount = cart.getAmount(product);
        model.addAttribute("id", id);
        model.addAttribute("amount", setAmount);
        return "edit_cart";
    }

    @PostMapping("shopping/edit")
    public String edit(@RequestParam(name="id") Integer id, @RequestParam(name="amount") Integer amount, Cart cart,Model model) {
        Product product = productService.findById(id);
        cart.editCart(product,amount);
        return "redirect:/shopping";
    }

    @GetMapping("shopping/delete")
    public String delete(@ModelAttribute("cart") Cart cart , @RequestParam Integer id){
        Product product= productService.findById(id);
        cart.delete(product);
        return "redirect:/shopping";
    }

    @GetMapping("shopping/delete/all")
    public String deleteAll(@ModelAttribute("cart") Cart cart){
        cart.deleteAll();
        return "redirect:/shopping";
    }

}
