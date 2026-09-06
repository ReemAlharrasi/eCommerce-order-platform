package eCommerceOrderPlatform.repositories;

import eCommerceOrderPlatform.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("SELECT p FROM Review r WHERE r.isActive=true")
    List<Review> getAllReviews();

    @Query ("SELECT r FROM Payment r WHERE r.isActive=true AND r.id=:id")
    Review getReviewById(@Param("id") Long id);
}

