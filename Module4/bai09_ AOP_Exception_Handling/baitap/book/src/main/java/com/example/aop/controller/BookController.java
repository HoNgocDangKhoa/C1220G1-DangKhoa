package com.example.aop.controller;

import com.example.aop.model.Book;
import com.example.aop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("")
    public String showBook(Model model) {
        model.addAttribute("listBook", bookService.findAll());
        return "list";
    }

    @GetMapping("/borrow")
    public String showBorrowBook(@RequestParam Integer id, Model model, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(id);
        if (book.getAmount() > 0) {
            book.setAmount(book.getAmount() - 1);
            bookService.save(book);
            redirectAttributes.addFlashAttribute("message", "Ok.Chốt Đơn");

        } else {
            redirectAttributes.addFlashAttribute("message", "Sorry");
        }
        model.addAttribute("bookList", bookService.findAll());
        return "redirect:/";
    }

    @GetMapping("/return")
    public String showReturn() {

        return "return";
    }
    @PostMapping("/return")
    public String returnBook( @RequestParam String borrow,Model model,RedirectAttributes redirectAttributes){
        Book book = bookService.findByBookCode(borrow);
        if(book !=null){
            book.setAmount(book.getAmount()+1);
            bookService.save(book);
            model.addAttribute("listBook",bookService.findAll());
            redirectAttributes.addFlashAttribute("message","Ơ mây zing gứt chốp");
        }else {
            redirectAttributes.addFlashAttribute("message","No gút chớp");
        }
        return "redirect:";
    }


}
