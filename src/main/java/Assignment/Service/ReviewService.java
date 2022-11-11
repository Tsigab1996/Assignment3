package Assignment.Service;

import Assignment.Dto.RequestReviewDTO;
import Assignment.Entity.Review;

import java.util.List;

public interface ReviewService {

    RequestReviewDTO save(RequestReviewDTO review);

    RequestReviewDTO update(Long id, RequestReviewDTO review);

    List<Review> getAllReview();

    List<Review> getAllReviewByProduct(Long productId);
}
