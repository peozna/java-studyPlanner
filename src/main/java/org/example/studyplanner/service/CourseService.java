package org.example.studyplanner.service;

import org.example.studyplanner.repository.CourseRepository;

import org.example.studyplanner.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public void createCourse(Long id, String name, String description) {
        Course newCourse = new Course(id, name, description);
        repository.save(newCourse);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Optional<Course> findCourse(Long id) {
        return repository.findById(id);
    }

    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }
}
