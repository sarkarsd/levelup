package com.levelup.backend.repository;

import com.levelup.backend.model.Task;
import com.levelup.backend.model.TaskStatus;
import com.levelup.backend.model.TaskType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
    // Spring auto-generates basic DB methods
   
    // Fetch tasks by user ID
   List<Task> findByUserId(Long userId);
    
   // Fetch tasks by user ID and task type
   List<Task> findByUserIdAndType(Long userId, TaskType type);

    // Fetch tasks by status (Pending, Completed, Failed)
    List<Task> findByStatus(TaskStatus status);

}
