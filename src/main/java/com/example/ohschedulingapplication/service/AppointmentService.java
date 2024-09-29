package com.example.ohschedulingapplication.service;

import com.example.ohschedulingapplication.entity.Appointment;
import com.example.ohschedulingapplication.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByStudent(Long studentId) {
        return appointmentRepository.findByStudentId(studentId);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
