package Assignment.Service;

import Assignment.Dto.RequestUserDTO;
import Assignment.Entity.User;

import java.util.List;

public interface UserService {

    RequestUserDTO save(RequestUserDTO user);

    RequestUserDTO update(Long id, RequestUserDTO user);

    List<User> getAllUser();

    Boolean deleteUser(Long id);
}