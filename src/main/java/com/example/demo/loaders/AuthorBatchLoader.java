package com.example.demo.loaders;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.graphql.execution.BatchLoaderRegistry;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class AuthorBatchLoader {

    public AuthorBatchLoader(BatchLoaderRegistry registry, AuthorRepository authorRepository) {
        registry
                .forTypePair(Integer.class, Author.class)
                .withName("authorLoader")
                .registerMappedBatchLoader((ids, env) ->
                        Mono.fromSupplier(() -> {
                            List<Author> authors = authorRepository.findAllById(ids);
                            return authors.stream().collect(Collectors.toMap(Author::getId, Function.identity()));
                        }));
    }
}