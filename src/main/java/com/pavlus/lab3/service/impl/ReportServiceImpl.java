package com.pavlus.lab3.service.impl;

import com.pavlus.lab3.model.Report;
import com.pavlus.lab3.repository.ReportRepo;
import com.pavlus.lab3.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    ReportRepo reportRepo;

    @Autowired
    public ReportServiceImpl(ReportRepo reportRepo) {
        this.reportRepo = reportRepo;
    }

    @Override
    public Report save(Report report) {
        return reportRepo.save(report);
    }

    @Override
    public void removeById(Integer id) {
        reportRepo.deleteById(id);
    }

    @Override
    public Optional<Report> findById(Integer id) {
        return reportRepo.findById(id);
    }

    @Override
    public List<Report> findAll() {
        return reportRepo.findAll();
    }

}
