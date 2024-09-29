package com.example.ohschedulingapplication.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OfficeHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long professorId;
    @ElementCollection
    private List<Long> studentIds = new ArrayList<>();
    private int capacity;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Constructor
    public OfficeHour(Long professorId, LocalDateTime startTime, LocalDateTime endTime, int capacity) {
        this.professorId = professorId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
