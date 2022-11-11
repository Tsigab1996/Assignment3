package Assignment.Service;

import Assignment.Dto.RequestAddressDTO;
import Assignment.Entity.Address;

import java.util.List;

public interface AddressService {

    RequestAddressDTO save(RequestAddressDTO address);

    RequestAddressDTO update(Long id, RequestAddressDTO address);

    List<Address> getAllAddress();

    Boolean deleteAddress(Long id);
}