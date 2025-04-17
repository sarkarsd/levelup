package com.levelup.backend.service;

import com.levelup.backend.model.Task;
import com.levelup.backend.model.User;
import com.levelup.backend.model.TaskStatus;
import com.levelup.backend.repository.TaskRepository;
import com.levelup.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService; // Injecting UserService to access calculateLevel method

    @Scheduled(cron = "0 * * * * ?")  
    public void checkExpiredTasks() {
        List<Task> tasks = taskRepository.findByStatus(TaskStatus.PENDING);

        for (Task task : tasks) {
            // If task deadline has passed and it's still not completed
            if (LocalDateTime.now().isAfter(task.getDeadline()) && task.getStatus() == TaskStatus.PENDING) {
                
                // Apply penalty XP (based on task type)
                int penaltyXp = switch (task.getType()) {
                    case MAIN -> 50;
                    case SIDE -> 20;
                    case DAILY -> 10;
                };

                User user = task.getUser();
                int newXp = user.getXp() - penaltyXp;
                user.setXp(Math.max(newXp, 0)); // Ensure XP doesn't go negative
                
                // Use the UserService to calculate the user's level
                user.setLevel(userService.calculateLevel(user.getXp()));
                userRepository.save(user);
                
                // Mark task as FAILED due to expiry
                task.setStatus(TaskStatus.FAILED);
                taskRepository.save(task);
            }
        }
    }


}
