package com.examplePoduct.com.ProductCategories.repository;

import com.examplePoduct.com.ProductCategories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
