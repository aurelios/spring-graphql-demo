package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.AuthorRepository;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CompletableFuture;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @SchemaMapping(typeName = "Book", field = "author")
    public CompletableFuture<Author> getAuthor(Book book, DataFetchingEnvironment env) {
        Integer authorId = book.getAuthor().getId();
        DataLoader<Integer, Author> loader = env.getDataLoader("authorLoader");
        return loader.load(authorId);
    }
}
