package com.mediscreen.ui.web.controller;

import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.proxies.PatientServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mediscreen.ui.web.exception.ExceptionMessage;

import java.util.List;

@Controller
@RequestMapping("/mediscreen")
public class PatientController {

    @Autowired
    private final PatientServiceProxy patientServiceProxy;

    public PatientController(PatientServiceProxy patientServiceProxy) {
        this.patientServiceProxy = patientServiceProxy;
    }

    @GetMapping("/")
    public String home (Model model) {
        return "home";
    }

    @GetMapping("/list")
    public String patientList (Model model) {
        List<Patient> patientList = patientServiceProxy.getAllPatient();
        model.addAttribute("patients", patientList);
        return "patientList";
    }

    @RequestMapping("/patient/")
    public String updatePatient(@RequestParam("id") Long id, Model model) {
            try {
                Patient patient = patientServiceProxy.getPatient(id);
                model.addAttribute("patient", patient);
                return "patient";
            } catch (Exception e) {
                ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
                model.addAttribute("Error",exceptionMessage.getMessage());
                List<Patient> patientList = patientServiceProxy.getAllPatient();
                model.addAttribute("patients", patientList);
                return "patientList";
            }
    }

    @PostMapping("/patient/update/{id}")
    public String updatePatientValidate(@PathVariable("id") Long id, Patient patient, Model model) {
        try {
            patientServiceProxy.updatePatient(id, patient);
            List<Patient> patientList = patientServiceProxy.getAllPatient();
            model.addAttribute("patients", patientList);
            return "patientList";
        } catch (Exception e) {
            ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
            model.addAttribute("Error",exceptionMessage.getMessage());
            return "patient";
        }
    }

    @GetMapping("/patient/add")
    public String addPatient(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "patientAdd";
    }
    @PostMapping("/patient/validate")
    public String addPatientValidate(Patient patient, Model model) {
        try {
            Patient patientAdded = patientServiceProxy.addPatient(patient);
            List<Patient> patientList = patientServiceProxy.getAllPatient();
            model.addAttribute("patients", patientList);
            return "patientList";
        } catch (Exception e) {
            ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
            model.addAttribute("Error",exceptionMessage.getMessage());
            return "patientAdd";
        }

    }

}
