package com.example.queryable.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QueryableFieldDTO {
    private String className;
    private String name;
    private String type;
    private List<String> validations;

    public QueryableFieldDTO(String className, String name, String type, List<String> validations) {
        this.className = className;
        this.name = name;
        this.type = type;
        this.validations = validations;
    }

    // Getters and setters
}