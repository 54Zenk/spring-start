package ru.beeline.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.beeline.demo.entity.User;
import ru.beeline.demo.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUserById(@RequestParam Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/updateUser")
    public void updateUser(@RequestBody User user, @RequestParam Long id) {
        userService.update(user, id);
    }
}


