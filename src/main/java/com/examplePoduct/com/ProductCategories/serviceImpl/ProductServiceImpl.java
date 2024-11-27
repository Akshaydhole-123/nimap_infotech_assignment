package com.examplePoduct.com.ProductCategories.serviceImpl;

import com.examplePoduct.com.ProductCategories.Interface.CategoryInterface;
import com.examplePoduct.com.ProductCategories.Interface.ProductInterface;
import com.examplePoduct.com.ProductCategories.entity.Category;
import com.examplePoduct.com.ProductCategories.entity.Product;
import com.examplePoduct.com.ProductCategories.repository.CategoryRepository;
import com.examplePoduct.com.ProductCategories.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductInterface {
    @Autowired
    ProductRepository productRepository;
    @Override
    public ResponseEntity<String> createProduct(Product product) {
        try{
            productRepository.save(product);
            return ResponseEntity.status(HttpStatus.OK).body("Product Created Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating category");
        }
    }

    @Override
    public ResponseEntity<List<Product>> findAll() {
        List<Product> productList = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @Override
    public ResponseEntity<String> updateProduct(Product product) {
        try{
            productRepository.save(product);
            return ResponseEntity.status(HttpStatus.OK).body("Product Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while updating product");
        }
    }

    @Override
    public ResponseEntity<Product> findByProductId(Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(product.get());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Override
    public ResponseEntity<String> deleteByProductId(Integer productId) {
        try{
            Optional<Product> product = productRepository.findById(productId);
            if(product.isPresent()) {
                productRepository.delete(product.get());
            }
            return ResponseEntity.status(HttpStatus.OK).body("Productp Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while Deleted product");
        }
    }
}
