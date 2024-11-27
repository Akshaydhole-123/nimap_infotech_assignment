package com.examplePoduct.com.ProductCategories.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.util.Lazy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.lang.constant.ConstantDesc;

@Table
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer productId;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "categoryId")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    @JsonBackReference
    private Category category;
}
