package com.example.user.service;

import java.util.List;
import com.example.user.entity.User;

public interface UserService {
    public String createUser(User user);
    public String updateUser(User user);
    public String deleteUser(Long id);
    public User getUser(Long id);
    public List<User> getAllUsers();
}
