package Assignment.Dto;

import lombok.Data;

@Data
public class RequestReviewDTO {

    private String comment;
    private Long userId;
    private Long productId;
}
