package com.examplePoduct.com.ProductCategories.Interface;

import com.examplePoduct.com.ProductCategories.entity.Category;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;
import java.util.List;

public interface CategoryInterface {
    public ResponseEntity<String> createCategory(Category category);

    ResponseEntity<List<Category>> findAll(PageRequest paging);

    ResponseEntity<String> updateCategory(Category category);

    ResponseEntity<Category> findByCategoryId(Integer categoryId);

    ResponseEntity<String> deleteCategory(Integer categoryId);
}
