package Assignment.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private Double price;
    private Integer rating;

    @ManyToOne
    @JsonBackReference
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}