package Assignment.Controller;

import Assignment.Dto.RequestUserDTO;
import Assignment.Entity.User;
import Assignment.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("reviews")
@RestController


public class UserController {

    private final UserService service;

    @PostMapping
    public RequestUserDTO createUser(@RequestBody RequestUserDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public RequestUserDTO updateUser(@PathVariable Long id, @RequestBody RequestUserDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public List<User> getAllUser() {
        return service.getAllUser();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Long id) {
        return service.deleteUser(id);
    }
}
