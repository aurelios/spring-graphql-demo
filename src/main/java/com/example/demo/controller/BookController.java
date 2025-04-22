package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.*;

@Controller
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book bookById(@Argument Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Book> bookByTitle(@Argument String title) {
        return bookRepository.findByTitleContaining(title);
    }

    @MutationMapping
    public Book addBook(@Argument Integer id, @Argument String title, @Argument Integer authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) return null;
        return bookRepository.save(new Book(id, title, author));
    }
}
