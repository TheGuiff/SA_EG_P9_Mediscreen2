package com.mediscreen.ui.controller;

import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.proxies.PatientServiceProxy;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mediscreen")
public class PatientController {

    private final PatientServiceProxy patientServiceProxy;

    public PatientController(PatientServiceProxy patientServiceProxy) {
        this.patientServiceProxy = patientServiceProxy;
    }

    @RequestMapping("/")
    public String home (Model model) {
        model.addAttribute("patientId", 1);
        return "home";
    }

    @RequestMapping("/list")
    public String patientList (Model model) {
        List<Patient> patientList = patientServiceProxy.getAllPatient();
        model.addAttribute("patients", patientList);
        return "patientList";
    }

    @GetMapping("/patient/{id}")
    public String patientById (@PathVariable("id") Long id, Model model) {
            Patient patient = patientServiceProxy.getPatient(id);
            model.addAttribute("patient", patient);
            return "patient";
    }

    @PostMapping("/patient/update/{id}")
    public String updatePatient(@PathVariable("id") Long id, Patient patient, Model model) {
        patientServiceProxy.updatePatient(id, patient);
        List<Patient> patientList = patientServiceProxy.getAllPatient();
        model.addAttribute("patients", patientList);
        return "patientList";
    }

    @GetMapping("/patient/add")
    public String patientById (Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "patientAdd";
    }
    @PostMapping("/patient/validate")
    public String addPatient(Patient patient, Model model) {
        Patient patientAdded = patientServiceProxy.addPatient(patient);
        List<Patient> patientList = patientServiceProxy.getAllPatient();
        model.addAttribute("patients", patientList);
        return "patientList";
    }

}
