package com.devzees.controller;

import com.devzees.model.User;
import com.devzees.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
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
    public HttpResponse<User> getUserById(@PathVariable Long id) {
        return HttpResponse.ok(userService.findById(id));
    }

    @Post("/update")
    public HttpResponse<User> updateUser(@Body User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return HttpResponse.ok(updatedUser);
        } else {
            return HttpResponse.status(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @Put("/update/email/{id}")
    public HttpResponse<User> updateUserEmail(@PathVariable Long id, @Body String email) {
        User updatedUser = userService.updateUserEmail(id, email);
        return HttpResponse.ok(updatedUser);
    }

    @Delete("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }



}