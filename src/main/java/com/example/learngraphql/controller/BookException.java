package com.example.learngraphql.controller;

public class BookException extends RuntimeException {

    int statusCode = 0;
    String message = "";

    public BookException() {

    }

    public BookException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }
}
