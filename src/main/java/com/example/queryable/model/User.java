package com.example.queryable.model;

import com.example.queryable.annotations.Queryable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {

    @Id
    private Long id;

    @Queryable
    @NotNull
    private String firstName;

    @Queryable
    @Size(min = 3, max = 50)
    private String lastName;

    private String password;

    @Queryable
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;
}
