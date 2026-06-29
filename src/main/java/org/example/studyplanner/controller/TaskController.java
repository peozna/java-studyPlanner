package org.example.studyplanner.controller;

import org.example.studyplanner.dto.TaskDTO;
import org.example.studyplanner.model.Task;
import org.example.studyplanner.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

        private final TaskService service;

        public TaskController(TaskService service) {
            this.service = service;
        }

        @GetMapping
        public List<Task> getTasks() {
            return service.getAllTasks();
        }

        @GetMapping("/{id}")
        public Optional<Task> getTask(@PathVariable Long id) {
            return service.findTask(id);
        }

        @PostMapping
        public Task createTask(@RequestBody TaskDTO taskDTO) {
            return service.createTask(taskDTO);
        }

        @DeleteMapping("/{id}")
        public void deleteTask(@PathVariable Long id) {
            service.deleteTask(id);
        }

        @PutMapping("/{id}")
        public Task updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) { return service.updateTask(id, taskDTO); }

        @PatchMapping("/{id}/complete")
        public Task completeTask(@PathVariable Long id) { return service.completeTask(id); }

}
