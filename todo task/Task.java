package com.example.todotracker.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskTitle;

    @Enumerated(EnumType.STRING)
    private Status taskStatus;

    public enum Status {
        YET_TO_START,
        IN_PROGRESS,
        COMPLETED
    }

    public Task() {}

    public Task(String taskTitle, Status taskStatus) {
        this.taskTitle = taskTitle;
        this.taskStatus = taskStatus;
    }

    // Getters and Setters
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }
}
