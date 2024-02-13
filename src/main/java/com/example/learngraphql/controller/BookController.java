package com.example.learngraphql.controller;

import com.example.learngraphql.model.Book;
import com.example.learngraphql.model.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //@SchemaMapping(typeName = "Query", value = "allBooks")
    @QueryMapping(value = "allBooks")
    public List<Book> findAll() {
        return bookRepository.finalAll();
    }

    @QueryMapping
    public Book findById(@Argument int id) {
        return  bookRepository.findById(id);
    }
}
