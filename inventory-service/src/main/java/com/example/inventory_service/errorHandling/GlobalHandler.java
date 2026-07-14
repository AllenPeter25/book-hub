package com.example.inventory_service.errorHandling;


import com.example.inventory_service.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<ErrorResponse> handleNotFound(BookNotFound ex, HttpServletRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("Not found")
                .path(request.getRequestURI())
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return  ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
}
