package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    private Integer id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    public Book() {
    }

    public Book(Integer id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public Author getAuthor() { return author; }

}
