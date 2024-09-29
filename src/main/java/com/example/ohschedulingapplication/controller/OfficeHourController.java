package com.example.ohschedulingapplication.controller;

import com.example.ohschedulingapplication.entity.OfficeHour;
import com.example.ohschedulingapplication.service.OfficeHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office-hours")
public class OfficeHourController {

    @Autowired
    private OfficeHourService officeHourService;

    // Create a new office hour
    @PostMapping
    public ResponseEntity<OfficeHour> createOfficeHour(@RequestBody OfficeHour officeHour) {
        return new ResponseEntity<>(officeHourService.createOfficeHour(officeHour), HttpStatus.CREATED);
    }

    // Get available office hours for a professor
    @GetMapping("/{professorId}/available")
    public ResponseEntity<List<OfficeHour>> getAvailableOfficeHours(@PathVariable Long professorId) {
        return new ResponseEntity<>(officeHourService.getAvailableOfficeHours(professorId), HttpStatus.OK);
    }

    // Update an office hour
    @PutMapping
    public ResponseEntity<Void> updateOfficeHour(@RequestBody OfficeHour officeHour) {
        officeHourService.updateOfficeHour(officeHour);
        return ResponseEntity.ok().build();
    }

    // Delete an office hour by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOfficeHour(@PathVariable Long id) {
        officeHourService.deleteOfficeHour(id);
        return ResponseEntity.ok().build();
    }
}

