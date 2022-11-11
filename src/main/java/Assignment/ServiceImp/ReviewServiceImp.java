package Assignment.ServiceImp;


import Assignment.Dto.RequestReviewDTO;
import Assignment.Entity.Review;
import Assignment.Repository.ProductRepository;
import Assignment.Repository.ReviewRepository;
import Assignment.Repository.UserRepository;
import Assignment.Service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImp implements ReviewService {

    private final ReviewRepository repository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public RequestReviewDTO save(RequestReviewDTO review) {

        Review r = new Review();
        BeanUtils.copyProperties(review, r, "id");
        // assume client provide valid info
        r.setUser(userRepository.findById(review.getUserId()).get());
        r.setProduct(productRepository.findById(review.getProductId()).get());
        repository.save(r);
        return review;
    }

    @Override
    public RequestReviewDTO update(Long id, RequestReviewDTO review) {
        Optional<Review> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Review not found!");
        }
        Review o = optional.get();
        BeanUtils.copyProperties(review, o, "id");
        // assume client provide valid info
        o.setProduct(productRepository.findById(review.getProductId()).get());
        o.setUser(userRepository.findById(review.getUserId()).get());
        repository.save(o);
        return review;
    }

    @Override
    public List<Review> getAllReview() {
        return repository.findAll();
    }

    @Override
    public List<Review> getAllReviewByProduct(Long productId) {
        return repository.findAllByProductId(productId);
    }
}
