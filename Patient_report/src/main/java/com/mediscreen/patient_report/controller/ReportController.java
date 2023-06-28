package com.mediscreen.patient_report.controller;

import com.mediscreen.patient_report.model.PatientAndNotes;
import com.mediscreen.patient_report.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/")
    public String report (@RequestBody PatientAndNotes patientAndNotes) {
        log.info("Get report");
        return reportService.calculReport(patientAndNotes);
    }

}
