package com.levelup.backend.controller;

import com.levelup.backend.model.User;
import com.levelup.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //Create a new user
    @PostMapping
    public User createuser(@RequestBody User user) {
        return userRepository.save(user);
    }

    //Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }  

}
