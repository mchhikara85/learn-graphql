package com.example.learngraphql.model;

import lombok.Data;

@Data
public class Author {

    int id;
    String firstName;
    String lastName;

    public Author() {}

    public Author(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}
