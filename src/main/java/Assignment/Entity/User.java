package Assignment.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToOne
    private Address address;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}