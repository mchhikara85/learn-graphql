package com.example.learngraphql.controller;

import com.example.learngraphql.model.Book;
import com.example.learngraphql.model.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //@SchemaMapping(typeName = "Query", value = "allBooks")
    @QueryMapping(value = "allBooks")
    public List<Book> findAll() {
        try {
            return bookRepository.finalAll();
        } catch (Exception ex) {
            throw new BookException(HttpStatus.FAILED_DEPENDENCY.value(), "Error loading books data.");
        }
    }

    @QueryMapping
    public Book findById(@Argument int id) {
        if (id > 0) {
            return findByIdRest(id);
        }
        throw new BookException(HttpStatus.NO_CONTENT.value(), "No book found");
    }

    @GetMapping
    public Book findByIdRest(int id) {
        return  bookRepository.findById(id);
    }

/*    query {
        allBooks {
            id,
                    title,
                    rating {
                star
            }
            author {
                lastName
            }
        }
    }

    query {
        findById(id:2) {
            title
            rating {
                star
            }
            author {
                firstName
            }
        }
    }*/
}
