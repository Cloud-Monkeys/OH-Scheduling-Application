package com.example.ohschedulingapplication.repository;

import com.example.ohschedulingapplication.entity.OfficeHour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficeHourRepository extends JpaRepository {
    List<OfficeHour> findByProfessorIdAndIsOpen(Long professorId);
}
