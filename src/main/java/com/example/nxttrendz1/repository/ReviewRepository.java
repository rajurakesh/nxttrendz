package com.example.nxttrendz1.repository;

import java.util.ArrayList;
import com.example.nxttrendz1.model.Review;

public interface ReviewRepository {
    ArrayList<Review> getReviews();

    Review addReview(Review review);

    Review getReviewById(int reviewId);

    Review updateReview(int reviewId, Review review);

    void deleteReview(int reviewId);
}