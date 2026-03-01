package uu.app.userservice.controller;

import org.springframework.web.bind.annotation.*;
import uu.app.userservice.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping
    public User createUser(@RequestBody User user) {
        users.add(user);

        return user;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }
}
