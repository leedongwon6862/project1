package com.example.demo;

import com.example.demo.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;



    // category 리스트를 보여주는 매서드
   public List<Category> getCategoryList(){
       return categoryRepository.findAll();
   }

    // category id 로 category 찾는 매서드
   public Category getCategoryById(Long id){
       return categoryRepository.findById(id).orElseThrow();
   }

   // category 생성
   public Category createCategory(@RequestParam String name){
       Category category = new Category();
       category.setName(name);
       return categoryRepository.save(category);
   }

   // category 삭제
   public void deleteCategory(Long id){
       categoryRepository.deleteById(id);
   }
}
