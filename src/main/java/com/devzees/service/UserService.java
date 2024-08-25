package com.devzees.service;

import com.devzees.model.User;

import java.util.List;

/**
 * Author: Zeeshan Adil
 * User:mhmdz
 * Date:24-08-2024
 * Time:18:36
 */

public interface UserService {

    User createUser(User user);
    List<User> findAll();
    User findById(Long id);

    User updateUser(User user);

    User updateUserEmail(Long userId, String email);
    void deleteById(Long id);
}