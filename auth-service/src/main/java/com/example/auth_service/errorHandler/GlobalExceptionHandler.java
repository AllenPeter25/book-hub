package com.example.auth_service.errorHandler;

import com.example.auth_service.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserExists.class)
    public ResponseEntity<ErrorResponse> handlerUserExists(UserExists userExists, HttpServletRequest req) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("Exists")
                .path(req.getRequestURI())
                .message(userExists.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
