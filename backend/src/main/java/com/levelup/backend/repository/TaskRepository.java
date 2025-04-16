package com.levelup.backend.repository;

import com.levelup.backend.model.Task;
import com.levelup.backend.model.TaskType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
    // Spring auto-generates basic DB methods
    List<Task> findByUserId(Long userId);
    List<Task> findByUserIdAndType(Long userId, TaskType type);

}
