package com.example.learngraphql.model.repository;

import com.example.learngraphql.model.Book;
import com.example.learngraphql.model.Rating;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {

    @Autowired
    private AuthorRepository authorRepository;

    private List<Book> books = new ArrayList<>();

    public List<Book> finalAll() {
        return books;
    }

    public Book findById(int id) {
        return books.stream().filter(a -> id == a.getId()).findFirst().orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostConstruct
    private void initialize() {
        books = Arrays.asList(
                new Book(1, "Science 1", 500, Rating.FIVE_STAR, authorRepository.findByFullName("Abhimanyu Chhikara")),
                new Book(2, "Science 2", 650, Rating.THREE_STAR, authorRepository.findByFullName("Test Writer")),
                new Book(3, "Science 3", 350, Rating.TWO_STAR, authorRepository.findByFullName("Manjeet Chhikara")),
                new Book(4, "Science 4", 880, Rating.FOUR_STAR, authorRepository.findByFullName("Abhimanyu Chhikara")),
                new Book(5, "Science 5", 675, Rating.TWO_STAR, authorRepository.findByFullName("Manjeet Chhikara"))
        );
    }
}
