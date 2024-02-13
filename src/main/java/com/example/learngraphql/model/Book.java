package com.example.learngraphql.model;

import lombok.Data;

@Data
public class Book {

    int id;
    String title;
    int pages;
    Rating rating;
    Author author;

    public Book() {}

    public Book(int id, String title, int pages, Rating rating, Author author) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.rating = rating;
        this.author = author;
    }
}
