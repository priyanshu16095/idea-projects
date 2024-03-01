package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "Created";
    }
    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "Updated";
    }
    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "Deleted";
    }
}
