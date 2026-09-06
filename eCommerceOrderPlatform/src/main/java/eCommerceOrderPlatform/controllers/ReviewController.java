package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Review;
import eCommerceOrderPlatform.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
public class ReviewController {

    ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("add")
    public Long addReview(
            @RequestParam Double rating,
            @RequestParam String comment) {

        return reviewService.createReview(rating, comment);
    }

    @GetMapping("getAll")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("getById")
    public Review getById(@RequestParam Long id) {
        return reviewService.getById(id);
    }

    @PutMapping("update")
    public Review updateReview(
            @RequestParam Long id,
            @RequestParam Double rating,
            @RequestParam String comment) {

        return reviewService.updateReview(
                id, rating, comment
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteReview(@RequestParam Long id) {
        return reviewService.deleteById(id);
    }
}