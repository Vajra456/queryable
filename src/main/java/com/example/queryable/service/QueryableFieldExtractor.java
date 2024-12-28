package com.example.queryable.service;

import com.example.queryable.annotations.Queryable;
import com.example.queryable.model.QueryableFieldDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class QueryableFieldExtractor {

    public static List<QueryableFieldDTO> getQueryableFields(Class<?> clazz) {
        List<QueryableFieldDTO> fields = new ArrayList<>();
        String className = clazz.getSimpleName();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Queryable.class)) {
                String fieldName = field.getName();
                String fieldType = field.getType().getSimpleName();

                List<String> validations = new ArrayList<>();

                // Extract validation annotations
                if (field.isAnnotationPresent(NotNull.class)) {
                    validations.add("NotNull");
                }
                if (field.isAnnotationPresent(Size.class)) {
                    Size size = field.getAnnotation(Size.class);
                    validations.add("Size(min=" + size.min() + ", max=" + size.max() + ")");
                }
                if (field.isAnnotationPresent(Pattern.class)) {
                    Pattern pattern = field.getAnnotation(Pattern.class);
                    validations.add("Pattern(" + pattern.regexp() + ")");
                }

                // Add className and field to the list
                fields.add(new QueryableFieldDTO(className, fieldName, fieldType, validations));
            }
        }
        return fields;
    }
}