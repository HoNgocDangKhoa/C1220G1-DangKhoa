package com.example.baitap.controller;

import com.example.baitap.model.Cart;
import com.example.baitap.model.Product;
import com.example.baitap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ModelAndView showList(Model model ,@PageableDefault(value = 4) Pageable pageable){
        return new ModelAndView("product/list","product",productService.findAll(pageable));
    }
    @GetMapping("/create")
    public String showForm(Model model, Product product){
        model.addAttribute("product",product);
        return "product/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute(name="product")Product product){
        productService.save(product);
        return "redirect:/";
    }
    @GetMapping("/view")
    public String showView(@RequestParam(name="id")Integer id,Model model){
        model.addAttribute(productService.findById(id));
        return "product/view";
    }

    @GetMapping("/carts")
    public String showList(Cart cart,Model model){
        model.addAttribute("cart",cart.getCart());
        return "/product/cart-list";
    }

    @PostMapping("/carts/create")
    public String createCart(Cart cart,Model model,@RequestParam Integer id){
        Product product = productService.findById(id);
        cart.addToCart(product);
        model.addAttribute("cart",cart.getCart());
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        System.out.println(attr.getRequest().getSession(true).getAttribute("cart"));
        return "product/cart-list";
    }


}
