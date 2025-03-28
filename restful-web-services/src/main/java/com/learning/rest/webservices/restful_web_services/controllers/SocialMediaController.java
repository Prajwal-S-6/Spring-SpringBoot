package com.learning.rest.webservices.restful_web_services.controllers;

import com.learning.rest.webservices.restful_web_services.dao.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SocialMediaController {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping(value = "users")
    public List<Users> getUsers() {
        return userDaoService.getAllUsers();
    }

    @GetMapping(value = "users/{id}")
    public Users getUsersById(@PathVariable int id) {
        Users user = userDaoService.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("User Not Found with id: " + id);
        }
        return user;
    }

    @PostMapping(value = "users", consumes = "application/json", produces = "application/json")
    public Users addUsers(@Valid @RequestBody Users user) {
        return userDaoService.save(user);
    }

    @DeleteMapping(value="users")
    public void deleteUsers(@RequestBody int id) {
        userDaoService.deleteUser(id);
    }







}
