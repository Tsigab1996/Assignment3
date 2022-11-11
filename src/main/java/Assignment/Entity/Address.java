package Assignment.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String zip;
    private String city;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private User user;

}