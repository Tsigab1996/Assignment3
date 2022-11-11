package Assignment.ServiceImp;

import Assignment.Dto.RequestUserDTO;
import Assignment.Entity.User;
import Assignment.Repository.AddressRepository;
import Assignment.Repository.UserRepository;
import Assignment.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    private final AddressRepository addressRepository;

    @Override
    public RequestUserDTO save(RequestUserDTO user) {
        User u = new User();
        BeanUtils.copyProperties(user, u, "id");
        u.setAddress(addressRepository.findById(user.getAddressId()).get());
        repository.save(u);
        return user;
    }

    @Override
    public RequestUserDTO update(Long id, RequestUserDTO user) {
        Optional<User> optional = repository.findById(id);
        if(optional.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        User o = optional.get();
        BeanUtils.copyProperties(user, o, "id");
        o.setAddress(addressRepository.findById(user.getAddressId()).get());
        repository.save(o);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public Boolean deleteUser(Long id) {
        repository.deleteById(id);
        return true;
    }
}
