package com.example.demo;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    // 상품리스트 보여주기
    @GetMapping("/list")
    public String getProductList(Model model) {
        List<Product> productList = productService.getProductList();
        List<Category> categoryList = categoryService.getCategoryList();
        model.addAttribute("productList", productList);
        model.addAttribute("categoryList", categoryList);
        return "product_list";
    }

    // 상품 디테일
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product_detail";

    }

    // 상품 생성
    @PostMapping("/create")
    public String createProduct(@RequestParam String name, @RequestParam Double price, @RequestParam String description) {
        productService.createProduct(name, price, description);
        return "redirect:/product/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        return "product_form";
    }


    //상품 삭제
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") Long productId) {
        productService.deleteProduct(productId);
        return "redirect:/product/list";
    }

    @GetMapping("/delete")
    public String deleteProduct() {
        return "product_delete";

    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Category> categoryList = categoryService.getCategoryList();
        model.addAttribute("categoryList", categoryList);
        return "product_create"; // 템플릿 이름
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam String name, @RequestParam Double price, @RequestParam String description, @RequestParam Long category) {
        productService.createProduct(name, price, description, category);
        return "redirect:/product/list";
    }
}
