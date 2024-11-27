package com.examplePoduct.com.ProductCategories.serviceImpl;

import com.examplePoduct.com.ProductCategories.Interface.CategoryInterface;
import com.examplePoduct.com.ProductCategories.entity.Category;
import com.examplePoduct.com.ProductCategories.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryInterface {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public ResponseEntity<String> createCategory(Category category) {
        try{
            categoryRepository.save(category);
            return ResponseEntity.status(HttpStatus.OK).body("Category Created Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating category");
        }
    }

    @Override
    public ResponseEntity<List<Category>> findAll(PageRequest paging) {
        Page<Category> categoryList = categoryRepository.findAll(paging);
        return ResponseEntity.status(HttpStatus.OK).body(categoryList.getContent());
    }

    @Override
    public ResponseEntity<String> updateCategory(Category category) {
        try{
            categoryRepository.save(category);
            return ResponseEntity.status(HttpStatus.OK).body("Category Updated Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while creating category");
        }
    }

    @Override
    public ResponseEntity<Category> findByCategoryId(Integer categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(category.get());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Integer categoryId) {
        try{
            Optional<Category> category = categoryRepository.findById(categoryId);
            if(category.isPresent()) {
                categoryRepository.delete(category.get());
            }
            return ResponseEntity.status(HttpStatus.OK).body("Category Deleted Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while Deleted category");
        }
    }
}
