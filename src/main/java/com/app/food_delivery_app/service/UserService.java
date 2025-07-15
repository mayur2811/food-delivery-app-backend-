package com.app.food_delivery_app.service;

import com.app.food_delivery_app.model.User;
import com.app.food_delivery_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        user.get().setName(userDetails.getName());
        user.get().setEmail(userDetails.getEmail());
        user.get().setPassword(userDetails.getPassword());
        user.get().setAddress(userDetails.getAddress());
        user.get().setPhone(userDetails.getPhone());
        return userRepository.save(user.get());
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}