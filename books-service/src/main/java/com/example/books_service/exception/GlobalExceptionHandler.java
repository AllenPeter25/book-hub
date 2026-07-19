package com.example.books_service.exception;

import com.example.books_service.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFound ex, HttpServletRequest request) {
        ErrorResponse errorResponse = ErrorResponse
                                        .builder()
                                        .timestamp(LocalDateTime.now())
                                        .status(HttpStatus.NOT_FOUND.value())
                                        .error("Not Found")
                                        .path(request.getRequestURI())
                                        .message(ex.getMessage())
                                        .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
}
