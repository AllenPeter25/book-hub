package com.example.books_service.exception;

public class BookNotFound extends RuntimeException {

    public BookNotFound(String message) {
        super(message);
    }
}
