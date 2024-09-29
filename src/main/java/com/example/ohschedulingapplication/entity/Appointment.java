package com.example.ohschedulingapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long studentId;
    private long officeHourId;

    // Constructors

    public Appointment() {}

    public Appointment(long studentId, long officeHourId) {
        this.studentId = studentId;
        this.officeHourId = officeHourId;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getOfficeHourId() {
        return officeHourId;
    }

    public void setOfficeHourId(Long officeHourId) {
        this.officeHourId = officeHourId;
    }
}
