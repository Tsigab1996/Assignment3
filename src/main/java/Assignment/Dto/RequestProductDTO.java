package Assignment.Dto;

import lombok.Data;

@Data
public class RequestProductDTO {
    private String name;

    private Double price;
    private Integer rating;
    private Long categoryId;
}