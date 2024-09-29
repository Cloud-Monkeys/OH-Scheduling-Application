package com.example.ohschedulingapplication.service;

import com.example.ohschedulingapplication.entity.OfficeHour;
import com.example.ohschedulingapplication.repository.OfficeHourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeHourService {
    @Autowired
    private OfficeHourRepository officeHourRepository;

    // Create a new office hour
    public OfficeHour createOfficeHour(OfficeHour officeHour) {
        return officeHourRepository.save(officeHour);
    }

    // Get available office hours for a professor
    public List<OfficeHour> getAvailableOfficeHours(Long professorId) {
        return officeHourRepository.findByProfessorIdAndIsOpen(professorId);
    }

    // Update an office hour
    public void updateOfficeHour(OfficeHour officeHour) {
        officeHourRepository.save(officeHour);
    }

    // Delete an office hour by ID
    public void deleteOfficeHour(Long id) {
        officeHourRepository.deleteById(id);
    }
}
