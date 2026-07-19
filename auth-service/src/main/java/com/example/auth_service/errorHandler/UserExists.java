package com.example.auth_service.errorHandler;

public class UserExists extends RuntimeException {

    public UserExists(String message) {
        super(message);
    }
}
