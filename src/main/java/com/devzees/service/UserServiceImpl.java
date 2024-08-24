package com.devzees.service;

import com.devzees.model.User;
import com.devzees.repository.UserRepository;
import jakarta.inject.Singleton;

import java.util.List;

/**
 * Author: Zeeshan Adil
 * User:mhmdz
 * Date:24-08-2024
 * Time:18:37
 */

@Singleton
public class UserServiceImpl implements UserService{

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
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}