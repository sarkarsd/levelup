package com.levelup.backend.dto;

import com.levelup.backend.model.TaskType;

public class TaskSummaryDTO {
    private String title;
    private TaskType type;
    private int xp;

    public TaskSummaryDTO(String title, TaskType type, int xp) {
        this.title = title;
        this.type = type;
        this.xp = xp;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public TaskType getType() {
        return type;
    }

    public int getXp() {
        return xp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
