package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public User getUserDetails(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }
    @GetMapping()
    public List<User> getAllUserDetails() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "Created";
    }

    @PutMapping
    public String upadteUser(@RequestBody User user) {
        userService.updateUser(user);
        return "Updated";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "Deleted";
    }
}