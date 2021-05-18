package com.pavlus.lab3.repository;

import com.pavlus.lab3.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepo extends JpaRepository<Report, Integer>{
}
