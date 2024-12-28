package com.example.queryable.controller;

import com.example.queryable.model.Product;
import com.example.queryable.model.QueryableFieldDTO;
import com.example.queryable.model.User;
import com.example.queryable.service.QueryableFieldExtractor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/queryable")
public class QueryableFieldController {

    private static final Map<String, Class<?>> ENTITY_MAP = new HashMap<>();

    static {
        ENTITY_MAP.put("user", User.class);
        ENTITY_MAP.put("product", Product.class);
    }

    @GetMapping
    public List<QueryableFieldDTO> getQueryableFields(@RequestParam String entity) {
        Class<?> clazz = ENTITY_MAP.get(entity.toLowerCase());

        if (clazz == null) {
            throw new IllegalArgumentException("Entity not found: " + entity);
        }

        return QueryableFieldExtractor.getQueryableFields(clazz);
    }
}