package org.example.studyplanner.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDTO {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
}