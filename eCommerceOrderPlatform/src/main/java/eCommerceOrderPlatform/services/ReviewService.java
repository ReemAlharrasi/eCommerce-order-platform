package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Customer;
import eCommerceOrderPlatform.entities.Product;
import eCommerceOrderPlatform.entities.Review;
import eCommerceOrderPlatform.repositories.CustomerRepository;
import eCommerceOrderPlatform.repositories.ProductRepository;
import eCommerceOrderPlatform.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    ReviewRepository reviewRepository;
    CustomerRepository customerRepository;
    ProductRepository productRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository,
                         CustomerRepository customerRepository,
                         ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    // create
    public Long createReview(Double rating, String comment, Long customerId, Long productId) {
        Review review = new Review();
        review.setRating(rating);
        review.setComment(comment);
        review.setReviewDate(new Date());
        review.setCustomer(resolveCustomer(customerId));
        review.setProduct(resolveProduct(productId));
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
    public Review updateReview(Long id, Double rating, String comment, Long customerId, Long productId) {
        Review review = reviewRepository.getReviewById(id);
        if (review == null) return new Review();
        review.setRating(rating);
        review.setComment(comment);
        review.setCustomer(resolveCustomer(customerId));
        review.setProduct(resolveProduct(productId));
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

    private Customer resolveCustomer(Long customerId) {
        if (customerId == null) return null;
        return customerRepository.getCustomerById(customerId);
    }

    private Product resolveProduct(Long productId) {
        if (productId == null) return null;
        return productRepository.getProductById(productId);
    }
}
