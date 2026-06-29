package org.example.studyplanner.service;

import org.example.studyplanner.dto.TaskDTO;
import org.example.studyplanner.model.Course;
import org.example.studyplanner.model.Task;
import org.example.studyplanner.repository.TaskRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(TaskDTO taskDTO) {
        String title = taskDTO.getTitle();
        String description = taskDTO.getDescription();
        LocalDate dueDate = taskDTO.getDueDate();
        Task newTask = new Task(title, description, dueDate);
        repository.save(newTask);
        return newTask;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> findTask(Long id) {
        return repository.findById(id);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public Task updateTask(Long id, TaskDTO taskDTO) {
        Optional<Task> task = findTask(id);
        Task taskToUpdate = task.get();

        if(!taskDTO.getTitle().isEmpty()) {
            taskToUpdate.setTitle(taskDTO.getTitle());
        }

        if (!taskDTO.getDescription().isEmpty()) {
            taskToUpdate.setDescription(taskDTO.getDescription());
        }

        if (taskDTO.getDueDate() != null) {
            taskToUpdate.setDueDate(taskDTO.getDueDate());
        }

        repository.save(taskToUpdate);

        return taskToUpdate;
    }

    public Task completeTask(Long id) {
        Optional<Task> task = findTask(id);

        Task taskToComplete = task.get();
        taskToComplete.setCompleted(true);

        repository.save(taskToComplete);

        return taskToComplete;
    }

    }

