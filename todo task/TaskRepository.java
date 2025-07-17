package com.example.todotracker.repository;

import com.example.todotracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskStatus(Task.Status taskStatus);
}
