package com.learnings.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Users> getUser() {
        return ResponseEntity.ok(userService.getUserData());
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer getUsersCount() {
        return userService.getUsersCount();
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
