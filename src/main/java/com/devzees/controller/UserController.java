package com.devzees.controller;

import com.devzees.model.User;
import com.devzees.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Author: Zeeshan Adil
 * User:mhmdz
 * Date:24-08-2024
 * Time:18:39
 */

@Controller("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Post
    public HttpResponse<User> createUser(@Body User user) {
        User createdUser = userService.createUser(user);
        return HttpResponse.created(createdUser);
    }

    @Get
    public HttpResponse<List<User>> getAllUsers() {
        return HttpResponse.ok(userService.findAll());
    }

    @Get("/{id}")
    public HttpResponse<User> getAllUsers(@PathVariable Long id) {
        return HttpResponse.ok(userService.findById(id));
    }


//
//    @Put("/{id}")
//    public User updateUser(@PathVariable Long id, @Body User user) {
//        user.setId(id);
//        return userService.save(user);
//    }

    @Delete("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }



}