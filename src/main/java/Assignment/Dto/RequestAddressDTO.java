package Assignment.Dto;

import lombok.Data;

@Data
public class RequestAddressDTO {
    private String street;
    private String zip;
    private String city;
}