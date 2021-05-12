package com.example.blog_extend.controler;


import com.example.blog_extend.entity.Blog;
import com.example.blog_extend.service.BlogService;
import com.example.blog_extend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Optional;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;


    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 5 ) Pageable pageable) {
        return new ModelAndView("blog_list", "listBlog", blogService.sort(pageable));
    }

    @GetMapping("/save")
    public String getForm(Model model, Pageable pageable) {
        model.addAttribute("add", new Blog());
        model.addAttribute("categories", categoryService.findAll(pageable));
        return "blog/save";
    }

    @PostMapping("/save")
    public String saveBlog(Blog blog) {
        if (blog.getId() != null) {
            System.out.println(blog.getRegistrationDate());
        } else {
            blog.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
        }
        blogService.save(blog);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String getForm(@RequestParam Long id, Model model, Pageable pageable) {
        model.addAttribute("categories", categoryService.findAll(pageable));
        model.addAttribute("edit", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String updateBlog(Blog blog) {
        blogService.save(blog);
        return "redirect:";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Long id) {
        blogService.remove(id);
        return "redirect:";
    }

    @GetMapping("/view")
    public String showViewBlog(Model model, @RequestParam Long id) {
        model.addAttribute("view", blogService.findById(id));
        return "blog/view";
    }

    //    @PostMapping("/search")
//    public String search(@RequestParam String keyword,Model model) {
//         model.addAttribute("listBlog",blogService.findByTitleContaining(keyword));
//        return "redirect:";
//    }
    @PostMapping("/search")
    public String listCustomer(Model model, @RequestParam Optional<String> keyword, Pageable pageable) {
        if (!keyword.isPresent()) {
            model.addAttribute("listBlog", blogService.findAll(pageable));
            return "blog_list";
        } else {
            String keywordOld = keyword.get();
            model.addAttribute("listBlog", blogService.search(keywordOld, pageable));
            return "blog_list";
        }
    }
}



