package org.example.studyplanner.controller;
import org.example.studyplanner.model.Course;
import org.example.studyplanner.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/courses/{id}")
    public List<Course> getCourses() {
        return service.getAllCourses();
    }

    public Optional<Course> getCourse(@PathVariable Long id) {
        return service.findCourse(id);
    }

    @PostMapping
    public Course createCourse(String name, String description) {
        return service.createCourse(name, description);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }

}
