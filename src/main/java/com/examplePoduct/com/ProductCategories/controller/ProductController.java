package com.examplePoduct.com.ProductCategories.controller;

import com.examplePoduct.com.ProductCategories.Interface.CategoryInterface;
import com.examplePoduct.com.ProductCategories.Interface.ProductInterface;
import com.examplePoduct.com.ProductCategories.entity.Category;
import com.examplePoduct.com.ProductCategories.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInterface productInterface;

    @PostMapping("/createProduct")
    public ResponseEntity<String> createCategory(@RequestBody Product product){
        return productInterface.createProduct(product);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        return productInterface.updateProduct(product);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "productId") String sortBy, @RequestParam(defaultValue = "ASC") String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        PageRequest pageable = PageRequest.of(page, size, sort);
        return productInterface.findAll(pageable);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> findByProductId(@PathVariable("id") Integer productId){
        return productInterface.findByProductId(productId);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteByProductId(@PathVariable("id") Integer productId){
        return productInterface.deleteByProductId(productId);
    }
}
