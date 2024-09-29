package com.example.ohschedulingapplication.controller;

import com.example.ohschedulingapplication.entity.OfficeHour;
import com.example.ohschedulingapplication.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    // Create a new office hour
    @PostMapping("/officehours")
    public ResponseEntity<OfficeHour> createOfficeHour(@RequestBody OfficeHour officeHour) {
        return new ResponseEntity<>(schedulingService.createOfficeHour(officeHour), HttpStatus.CREATED);
    }

    // Get available office hours for a professor
    @GetMapping("/officehours/{professorId}/available")
    public ResponseEntity<List<OfficeHour>> getAvailableOfficeHours(@PathVariable Long professorId) {
        return new ResponseEntity<>(schedulingService.getAvailableOfficeHours(professorId), HttpStatus.OK);
    }

    // Update an office hour
    @PutMapping("/officehours")
    public ResponseEntity<Void> updateOfficeHour(@RequestBody OfficeHour officeHour) {
        schedulingService.updateOfficeHour(officeHour);
        return ResponseEntity.ok().build();
    }

    // Delete an office hour by ID
    @DeleteMapping("/officehours/{id}")
    public ResponseEntity<Void> deleteOfficeHour(@PathVariable Long id) {
        schedulingService.deleteOfficeHour(id);
        return ResponseEntity.ok().build();
    }

    // Add a student to an office hour
    @PutMapping("/officehours/{officeHourId}/addStudent/{studentId}")
    public ResponseEntity<OfficeHour> addStudentToOfficeHour(@PathVariable Long officeHourId, @PathVariable Long studentId) {
        try {
            return new ResponseEntity<>(schedulingService.addStudentToOfficeHour(officeHourId, studentId), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Remove a student from an office hour
    @PutMapping("/officehours/{officeHourId}/removeStudent/{studentId}")
    public ResponseEntity<OfficeHour> removeStudentFromOfficeHour(@PathVariable Long officeHourId, @PathVariable Long studentId) {
        return new ResponseEntity<>(schedulingService.removeStudentFromOfficeHour(officeHourId, studentId), HttpStatus.OK);
    }
}

