package com.example.todotracker.controller;

import com.example.todotracker.model.Task;
import com.example.todotracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/status")
    public List<Task> getTasksByStatus(@RequestParam Task.Status status) {
        return taskService.getTasksByStatus(status);
    }

    @PutMapping("/{id}/status")
    public Task updateTaskStatus(@PathVariable("id") Long taskId, @RequestParam Task.Status status) {
        return taskService.updateTaskStatus(taskId, status);
    }

    @PutMapping("/{id}/title")
    public Task updateTaskTitle(@PathVariable("id") Long taskId, @RequestParam String title) {
        return taskService.updateTaskTitle(taskId, title);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
        return "Task deleted with ID: " + taskId;
    }
}
