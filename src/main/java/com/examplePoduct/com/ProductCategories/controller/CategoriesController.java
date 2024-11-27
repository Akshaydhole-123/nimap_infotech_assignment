package com.examplePoduct.com.ProductCategories.controller;

import com.examplePoduct.com.ProductCategories.Interface.CategoryInterface;
import com.examplePoduct.com.ProductCategories.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoriesController {

    @Autowired
    private CategoryInterface categoryInterface;

    @PostMapping("/create")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        return categoryInterface.createCategory(category);
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<String> updateCategory(@RequestBody Category category){
        return categoryInterface.updateCategory(category);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> findAll(){
        return categoryInterface.findAll();
    }

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<Category> findByCategoryId(@PathVariable("id") Integer categoryId){
        return categoryInterface.findByCategoryId(categoryId);
    }

    @GetMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer categoryId){
        return categoryInterface.deleteCategory(categoryId);
    }
}
