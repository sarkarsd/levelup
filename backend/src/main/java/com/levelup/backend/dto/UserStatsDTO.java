package com.levelup.backend.dto;

import java.util.Map;
import java.util.List;

public class UserStatsDTO {
    private Long id;
    private String name; // ✅ Add this
    private int totalXp;
    private int level;
    private Map<String, Long> taskCountByType;
    private Map<String, Long> taskCountByStatus;
    private List<TaskSummaryDTO> tasks; // New field

    // ✅ Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalXp() { return totalXp; }
    public void setTotalXp(int totalXp) { this.totalXp = totalXp; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public Map<String, Long> getTaskCountByType() { return taskCountByType; }
    public void setTaskCountByType(Map<String, Long> taskCountByType) { this.taskCountByType = taskCountByType; }

    public Map<String, Long> getTaskCountByStatus() { return taskCountByStatus; }
    public void setTaskCountByStatus(Map<String, Long> taskCountByStatus) { this.taskCountByStatus = taskCountByStatus; }

    public List<TaskSummaryDTO> getTasks() { return tasks; }
    public void setTasks(List<TaskSummaryDTO> tasks) { this.tasks = tasks; }


}
