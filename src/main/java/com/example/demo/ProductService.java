package com.example.demo;

import com.example.demo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    public Product createProduct(@RequestParam  String name , double price , String description){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
         productRepository.deleteById(id);
    }
}
