package com.mediscreen.ui.proxies;

import com.mediscreen.ui.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(value="Patient-service", url="${clients.patientserviceurl}")
public interface PatientServiceProxy {

    @GetMapping("/patient/")
    List<Patient> getAllPatient();

    @GetMapping("/patient/{id}")
    Patient getPatient(@PathVariable("id") Long id);

    @PutMapping("/patient/{id}")
    Patient updatePatient(@PathVariable("id") Long id, Patient patient);

    @PostMapping("/patient/add")
    Patient addPatient(Patient patient);

}
