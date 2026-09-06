package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Review;
import eCommerceOrderPlatform.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // create
    public Long createReview(Double rating, String comment) {
        Review review = new Review();
        review.setRating(rating);
        review.setComment(comment);
        review.setReviewDate(new Date());
        review = reviewRepository.save(review);
        return review.getId();
    }

    // get all
    public List<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    // get by id
    public Review getById(Long id) {
        Review review = reviewRepository.getReviewById(id);
        if (review == null) return new Review();
        return review;
    }

    // update
    public Review updateReview(Long id, Double rating, String comment) {
        Review review = reviewRepository.getReviewById(id);
        if (review == null) return new Review();
        review.setRating(rating);
        review.setComment(comment);
        return reviewRepository.save(review);
    }

    // delete
    public Boolean deleteById(Long id) {
        Review review = reviewRepository.getReviewById(id);
        if (review == null) return false;
        review.setIsActive(false);
        review.setUpdatedDate(new Date());
        reviewRepository.save(review);
        return true;
    }
}