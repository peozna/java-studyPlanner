package org.example.studyplanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    public Course() {}

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
