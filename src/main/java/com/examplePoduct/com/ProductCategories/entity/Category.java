package com.examplePoduct.com.ProductCategories.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "category")
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer categoryId;

    private String categoryName;
//    @ElementCollection
@OneToMany(cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "category", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Product> productList;

    }
