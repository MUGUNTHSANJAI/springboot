package com.example.todotracker.service;

import com.example.todotracker.model.Task;
import com.example.todotracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setTaskStatus(Task.Status.YET_TO_START);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + taskId));
    }

    public List<Task> getTasksByStatus(Task.Status taskStatus) {
        return taskRepository.findByTaskStatus(taskStatus);
    }

    public Task updateTaskStatus(Long taskId, Task.Status newStatus) {
        Task task = getTaskById(taskId);
        task.setTaskStatus(newStatus);
        return taskRepository.save(task);
    }

    public Task updateTaskTitle(Long taskId, String newTitle) {
        Task task = getTaskById(taskId);
        task.setTaskTitle(newTitle);
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        Task task = getTaskById(taskId);
        taskRepository.delete(task);
    }
}
