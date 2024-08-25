package com.devzees.service;

import com.devzees.model.User;
import com.devzees.repository.UserRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Objects;

/**
 * Author: Zeeshan Adil
 * User:mhmdz
 * Date:24-08-2024
 * Time:18:37
 */

@Singleton
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            // Update only the necessary fields
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAge(user.getAge());

            // Save the updated user
            return userRepository.update(existingUser);
        }
        return null; // or throw an exception if the user is not found
    }

    @Override
    public User updateUserEmail(Long userId, String email) {
        User existingUser = userRepository.findById(userId).orElse(null);
        assert existingUser != null;
        existingUser.setEmail(email);
        return userRepository.update(existingUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}