package com.pavlus.lab3.controller;

import com.pavlus.lab3.mapper.ReportMapper;
import com.pavlus.lab3.model.Report;
import com.pavlus.lab3.model.dto.ReportDTO;
import com.pavlus.lab3.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/reports")
public class ReportController {

    ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ReportDTO>> findAll() {
        return ResponseEntity.ok(ReportMapper.INSTANCE.reportToReportDTOs(reportService.findAll()));
    }

    @PostMapping("/")
    public ResponseEntity<ReportDTO> create(@RequestBody ReportDTO reportDTO) {
        reportService.save(ReportMapper.INSTANCE.toReport(reportDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(reportDTO);
    }

    @GetMapping(value = "/reportByCode/{reportCode}")
    public ResponseEntity<ReportDTO> findById(@PathVariable int reportCode) {
        Optional<Report> report = reportService.findById(reportCode);

        return ResponseEntity.ok(ReportMapper.INSTANCE.toDTO(report.get()));
    }

    @PutMapping("/{reportCode}")
    public ResponseEntity<ReportDTO> update(@PathVariable int reportCode, @RequestBody ReportDTO reportDTO) {
        Report report = ReportMapper.INSTANCE.toReport(reportDTO);
        report.setReportCode(reportCode);

        reportService.save(report);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reportDTO);
    }

    @DeleteMapping("/{reportCode}")
    public ResponseEntity delete(@PathVariable int reportCode) {
        reportService.removeById(reportCode);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
