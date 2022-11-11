package Assignment.Controller;

import Assignment.Dto.RequestAddressDTO;
import Assignment.Entity.Address;
import Assignment.Service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RequestMapping("addresses")
@RestController

public class AddressController {

    private final AddressService service;

    @PostMapping
    public RequestAddressDTO createAddress(@RequestBody RequestAddressDTO address) {
        return service.save(address);
    }

    @PutMapping("/{id}")
    public RequestAddressDTO updateAddress(@PathVariable Long id, @RequestBody RequestAddressDTO address) {
        return service.update(id, address);
    }

    @GetMapping
    public List<Address> getAllAddress() {
        return service.getAllAddress();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteAddress(@PathVariable Long id) {
        return service.deleteAddress(id);
    }
}
