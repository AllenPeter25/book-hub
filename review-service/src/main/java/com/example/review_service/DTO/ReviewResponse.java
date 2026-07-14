package com.example.review_service.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewResponse {

    private String id;

    private Long bookId;

    private String userName;

    private Integer rating;

    private String comment;

    private LocalDateTime createdAt;
}
