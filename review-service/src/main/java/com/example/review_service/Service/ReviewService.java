package com.example.review_service.Service;

import com.example.review_service.DTO.ReviewRequest;
import com.example.review_service.DTO.ReviewResponse;
import com.example.review_service.Entity.Review;

import java.util.List;

public interface ReviewService {

    ReviewResponse createReview(ReviewRequest request);

    List<ReviewResponse> getReviewsByBookId(Long id);

    List<ReviewResponse> getReviewOfUsers(String name);

    void deleteReview(String reviewId);

    ReviewResponse findReviewById(String reviewId);
}
