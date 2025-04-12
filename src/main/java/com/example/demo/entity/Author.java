package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    private Integer id;
    private String name;

    public Author() {}

    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
}
