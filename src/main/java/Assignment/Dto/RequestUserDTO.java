package Assignment.Dto;

import lombok.Data;

@Data
public class RequestUserDTO {

    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Long addressId;
}