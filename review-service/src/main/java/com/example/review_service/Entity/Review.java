package com.example.review_service.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reviewdb")
@Builder
public class Review {

    @Id
    private String id;

    private Long bookId;

    private String userName;

    private Integer rating;

    private String comment;

    private LocalDateTime createdAt;
}
