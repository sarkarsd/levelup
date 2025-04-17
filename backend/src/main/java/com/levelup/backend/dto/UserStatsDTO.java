package com.levelup.backend.dto;

import java.util.Map;

public class UserStatsDTO {
    private int totalXp;
    private int level;
    private Map<String, Long> taskCountByType;
    private Map<String, Long> taskCountByStatus;

    // ✅ Getters and setters
    public int getTotalXp() { return totalXp; }
    public void setTotalXp(int totalXp) { this.totalXp = totalXp; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public Map<String, Long> getTaskCountByType() { return taskCountByType; }
    public void setTaskCountByType(Map<String, Long> taskCountByType) { this.taskCountByType = taskCountByType; }

    public Map<String, Long> getTaskCountByStatus() { return taskCountByStatus; }
    public void setTaskCountByStatus(Map<String, Long> taskCountByStatus) { this.taskCountByStatus = taskCountByStatus; }


}
