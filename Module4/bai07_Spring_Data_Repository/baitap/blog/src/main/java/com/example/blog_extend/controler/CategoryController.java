package com.example.blog_extend.controler;

import com.example.blog_extend.entity.Category;
import com.example.blog_extend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("category")
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("category_list", "categoryList", categoryService.findAll(pageable));
    }

    @GetMapping("/create")
    public String getForm(Model model) {
        model.addAttribute("createCategory", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String save(Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("message","New successfully added");
        return "redirect:/category";
    }
    @GetMapping("/edit")
    public String getForm(@RequestParam Long id, Model model){
        model.addAttribute("editCategory",categoryService.findById(id));
        return "category/edit";
    }
    @PostMapping("/edit")
    public String update(Category category){
        categoryService.saveCategory(category);
        return "redirect:";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes){
        categoryService.deleteCategory(id);
        redirectAttributes.addFlashAttribute("message","delete successfully");
        return "redirect:/category";
    }
    @GetMapping("/view")
    public String showView(@RequestParam Long id,Model model){
        model.addAttribute("view",categoryService.findById(id));
        return "category/view";
    }

}
