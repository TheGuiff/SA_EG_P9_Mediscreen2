package com.mediscreen.ui.proxies;

import com.mediscreen.ui.model.PatientAndNotes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value="Patient-report", url="localhost:8083")
public interface ReportServiceProxy {

    @PostMapping("/diabetreport/")
    String report(PatientAndNotes patientAndNotes);

}
