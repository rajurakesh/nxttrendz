package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.nxttrendz1.repository.ReviewRepository;
import com.example.nxttrendz1.model.Review;
import com.example.nxttrendz1.repository.ReviewJpaRepository;

@Service
public class ReviewJpaService implements ReviewRepository {
	@Autowired
	private ReviewJpaRepository reviewJpaRepository;

	@Override
	public ArrayList<Review> getReviews() {
		List<Review> reviewList = reviewJpaRepository.findAll();
		ArrayList<Review> reviews = new ArrayList<>(reviewList);
		return reviews;
	}

	@Override
	public Review addReview(Review review) {
		reviewJpaRepository.save(review);
		return review;
	}

	@Override
	public Review getReviewById(int reviewId) {
		try {
			Review review = reviewJpaRepository.findById(reviewId).get();
			return review;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Review updateReview(int reviewId, Review review) {
		try {
			Review newReview = reviewJpaRepository.findById(reviewId).get();
			if (review.getReviewContent() != null) {
				newReview.setReviewContent(review.getReviewContent());
			}
			if (review.getRating() != 0) {
				newReview.setRating(review.getRating());
			}
			reviewJpaRepository.save(newReview);
			return newReview;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteReview(int reviewId) {
		reviewJpaRepository.deleteById(reviewId);

	}

}