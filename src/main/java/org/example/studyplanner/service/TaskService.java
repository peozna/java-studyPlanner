package org.example.studyplanner.service;

import org.example.studyplanner.dto.CourseDTO;
import org.example.studyplanner.dto.TaskDTO;
import org.example.studyplanner.model.Course;
import org.example.studyplanner.model.Task;
import org.example.studyplanner.repository.CourseRepository;
import org.example.studyplanner.repository.TaskRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(@RequestBody TaskDTO taskDTO) {
        TaskDTO dto =  taskDTO;
        String title = dto.getTitle();
        String description = dto.getDescription();
        LocalDate dueDate = dto.getDueDate();
        Task newTask = new Task(title, description, dueDate);
        repository.save(newTask);
        return newTask;
    }
}
