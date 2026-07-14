package com.example.review_service.Repository;

import com.example.review_service.Entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByBookId(Long id);

    List<Review> findByUserName(String userName);
}
