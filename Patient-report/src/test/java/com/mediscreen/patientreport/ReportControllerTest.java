package com.mediscreen.patientreport;

import com.mediscreen.patientreport.controller.ReportController;
import com.mediscreen.patientreport.model.PatientAndNotes;
import com.mediscreen.patientreport.service.ReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReportControllerTest {

    @Autowired
    ReportController reportController;

    @MockBean
    ReportService reportService;

    @Test
    public void reportControllerTest() {
        when(reportService.calculReport(any())).thenReturn("report");
        assertEquals("report", reportController.report(new PatientAndNotes()));
    }
}
