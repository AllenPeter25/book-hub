package com.example.review_service.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private LocalDateTime timestamp;
    private String path;
    private String message;
    private int status;
    private String error;
}
