package com.levelup.backend.controller;

import com.levelup.backend.dto.UserStatsDTO;
import com.levelup.backend.model.User;
import com.levelup.backend.repository.UserRepository;
import com.levelup.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService; 

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

    // Get stats of the user with {id}
    @GetMapping("/{id}/stats")
    public ResponseEntity<UserStatsDTO> getUserStats(@PathVariable Long id) {
        UserStatsDTO stats = userService.getUserStats(id);
        return ResponseEntity.ok(stats);
    }


}
