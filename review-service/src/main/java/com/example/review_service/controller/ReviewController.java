package com.example.review_service.controller;

import com.example.review_service.DTO.ReviewRequest;
import com.example.review_service.DTO.ReviewResponse;
import com.example.review_service.Service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    public final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse create(@Valid @RequestBody ReviewRequest reviewRequest) {
        return reviewService.createReview(reviewRequest);
    }

    @GetMapping("/{id}")
    public ReviewResponse getReviewById(@PathVariable String id) {
        return reviewService.findReviewById(id);
    }

    @GetMapping("/books/{id}")
    public List<ReviewResponse> getAllBooksReview(@PathVariable Long id) {
        return reviewService.getReviewsByBookId(id);
    }

    @GetMapping("/user/{name}")
    public List<ReviewResponse> getByName(@PathVariable String name) {
        return reviewService.getReviewOfUsers(name);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable String id) {
        reviewService.deleteReview(id);
    }
}
