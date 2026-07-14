package com.example.books_service.client;

import com.example.books_service.dto.ReviewResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "review-service")
public interface ReviewClient {

    @GetMapping("/reviews/books/{id}")
    List<ReviewResponse> getReviewsById(@PathVariable Long id);
}
