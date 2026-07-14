package com.example.review_service.Service;

import com.example.review_service.DTO.ReviewRequest;
import com.example.review_service.DTO.ReviewResponse;
import com.example.review_service.Entity.Review;
import com.example.review_service.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceimpl implements ReviewService {

    private final ReviewRepository reviewRepository;


    @Override
    public ReviewResponse createReview(ReviewRequest request) {
        Review review = Review.builder()
                .bookId(request.getBookId())
                .userName(request.getUserName())
                .rating(request.getRating())
                .comment(request.getComment())
                .createdAt(LocalDateTime.now())
                .build();

        Review savedReview = reviewRepository.save(review);

        return ReviewResponse.builder()
                .id(savedReview.getId())
                .bookId(savedReview.getBookId())
                .rating(savedReview.getRating())
                .comment(savedReview.getComment())
                .createdAt(savedReview.getCreatedAt())
                .userName(savedReview.getUserName())
                .build();
    }

    @Override
    public List<ReviewResponse> getReviewsByBookId(Long id) {
        List<Review> bookReviews =  reviewRepository.findByBookId(id);
        return bookReviews.stream()
                .map(review ->
                        ReviewResponse.builder()
                                .id(review.getId())
                                .bookId(review.getBookId())
                                .rating(review.getRating())
                                .comment(review.getComment())
                                .userName(review.getUserName())
                                .createdAt(review.getCreatedAt())
                                .build()
                ).toList();
    }

    @Override
    public List<ReviewResponse> getReviewOfUsers(String name) {
        List<Review> reviews = reviewRepository.findByUserName(name);

        return reviews.stream()
                .map(review -> ReviewResponse.builder()
                        .id(review.getId())
                        .bookId(review.getBookId())
                        .comment(review.getComment())
                        .createdAt(review.getCreatedAt())
                        .rating(review.getRating())
                        .userName(review.getUserName())
                        .build()
                ).toList();
    }

    @Override
    public void deleteReview(String reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public ReviewResponse findReviewById(String reviewId) {
        Review response = reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("review not found"));

        return ReviewResponse.builder()
                .userName(response.getUserName())
                .rating(response.getRating())
                .id(response.getId())
                .bookId(response.getBookId())
                .comment(response.getComment())
                .createdAt(response.getCreatedAt())
                .build();
    }
}
