package com.example.learngraphql.model.repository;

import com.example.learngraphql.model.Author;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public List<Author> finalAll() {
        return authors;
    }

    public Author findById(int id) {
        return authors.stream().filter(a -> id == a.getId()).findFirst().orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author findByFullName(String fullName) {
        return authors.stream().filter(a -> fullName.equalsIgnoreCase(a.fullName())).findFirst().orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @PostConstruct
    private void initialize() {
        authors = Arrays.asList(
                new Author(1, "Manjeet", "Chhikara"),
                new Author(2, "Abhimanyu", "Chhikara"),
                new Author(3, "Test", "Writer")
        );
    }
}
