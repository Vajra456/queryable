package com.example.queryable.model;

import com.example.queryable.annotations.Queryable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Product {

    @Id
    private Long id;

    @Queryable
    @NotNull
    private String productName;

    @Queryable
    private String category;

    @Queryable
    private Double price;
}