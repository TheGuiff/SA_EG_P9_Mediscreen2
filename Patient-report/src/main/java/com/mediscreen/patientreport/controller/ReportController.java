package com.mediscreen.patientreport.controller;

import com.mediscreen.patientreport.model.PatientAndNotes;
import com.mediscreen.patientreport.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/diabetreport")
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping("/")
    public String report (@RequestBody PatientAndNotes patientAndNotes) {
        log.info("Get report");
        return reportService.calculReport(patientAndNotes);
    }

}
