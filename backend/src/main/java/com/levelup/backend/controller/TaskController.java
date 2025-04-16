package com.levelup.backend.controller;


import com.levelup.backend.model.*;
import com.levelup.backend.repository.TaskRepository;
import com.levelup.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    // POST /tasks – create a task

    @PostMapping
    public String createTask(@RequestBody Task task) {
        // Step 1: Find the user from DB
        User user = userRepository.findById(task.getUser().getId())
                .orElse(null);

        if (user == null) {
            return "User not found!";
        }

    
        // Step 2: Check if user already has a MAIN task

        if (task.getType() == TaskType.MAIN) {
            List<Task> existingMainTasks = taskRepository.findByUserIdAndType(user.getId(), TaskType.MAIN);
            if (!existingMainTasks.isEmpty()) {
                return "User already has a MAIN task!";
            }
        }


        
        // Step 3: Set default values
        task.setUser(user);
        task.setStatus(TaskStatus.PENDING);
        task.setCreatedAt(LocalDateTime.now());
        
        
        
        // Step 4: Assign XP based on type

        switch (task.getType()) {
            case MAIN -> task.setXp(50);
            case SIDE -> task.setXp(20);
            case DAILY -> task.setXp(10);
        }
    
        taskRepository.save(task);
        return "Task created!";
    
    }



    // GET /tasks/user/{userId} – fetch tasks by user

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        return taskRepository.findByUserId(userId);
    }

}
