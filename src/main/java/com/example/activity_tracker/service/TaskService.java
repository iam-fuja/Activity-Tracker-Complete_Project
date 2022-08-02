package com.example.activity_tracker.service;

import com.example.activity_tracker.dto.requests.TaskEditDTO;
import com.example.activity_tracker.dto.requests.TaskResponseDTO;
import com.example.activity_tracker.model.Task;

import java.util.List;

public interface TaskService {

    List<TaskResponseDTO> retrieveUserTasks();

    Task createTask(TaskEditDTO task);

    Task editTask(Long id, TaskEditDTO task);

    Task deleteTask(Long id);
}
