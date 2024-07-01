package com.example.demo;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;


    @GetMapping("list")
    public String getCategoryList(Model model){
        List<Category> categoryList = categoryService.getCategoryList();
        model.addAttribute("categoryList" , categoryList);
        return "category_list";
    }

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable("id") Long id , Model model){
       Category categoryList =categoryService.getCategoryById(id);
        return "category_detail";
    }

    @RequestMapping("/form")
    public String form(){
        return "category_form";
    }

    @PostMapping("/create")
    public String createCategory(String name){
      categoryService.createCategory(name);
        return "/category_list";
    }

    @PostMapping("/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "/category_list";
    }



}
