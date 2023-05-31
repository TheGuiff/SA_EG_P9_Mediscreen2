package com.mediscreen.ui.proxies;

import com.mediscreen.ui.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="mediscreenPatientService", url="localhost:8080")
public interface PatientServiceProxy {

    @GetMapping(value="/patient/")
    List<PatientBean> listeDesPatients();

    @GetMapping(value="Patient/{id}")
    PatientBean patientById(@PathVariable("id") Long id);
}
