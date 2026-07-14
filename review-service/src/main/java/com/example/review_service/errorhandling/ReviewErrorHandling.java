package com.example.review_service.errorhandling;


public class ReviewErrorHandling extends RuntimeException{
    public ReviewErrorHandling(String message) {
        super(message);
    }
}
