package Assignment.Controller;

import Assignment.Dto.RequestReviewDTO;
import Assignment.Entity.Review;
import Assignment.Service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("reviews")
@RestController


public class ReviewController {
    private final ReviewService service;

    @PostMapping
    public RequestReviewDTO createReview(@RequestBody RequestReviewDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public RequestReviewDTO updateReview(@PathVariable Long id, @RequestBody RequestReviewDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public List<Review> getAllReview() {
        return service.getAllReview();
    }

    @GetMapping("/products/{id}")
    public List<Review> getAllReviewByProduct(@PathVariable Long id) {
        return service.getAllReviewByProduct(id);
    }

}
