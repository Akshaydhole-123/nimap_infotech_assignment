package com.examplePoduct.com.ProductCategories.Interface;

import com.examplePoduct.com.ProductCategories.entity.Category;
import com.examplePoduct.com.ProductCategories.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductInterface {

    ResponseEntity<String> deleteByProductId(Integer productId);

    ResponseEntity<Product> findByProductId(Integer productId);

    ResponseEntity<List<Product>> findAll();

    ResponseEntity<String> updateProduct(Product product);

    ResponseEntity<String> createProduct(Product product);
}
