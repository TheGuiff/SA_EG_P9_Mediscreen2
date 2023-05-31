package com.mediscreen.ui.controller;

import com.mediscreen.ui.beans.PatientBean;
import com.mediscreen.ui.proxies.PatientServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/mediscreen")
public class PatientController {

    private final PatientServiceProxy patientServiceProxy;

    public PatientController(PatientServiceProxy patientServiceProxy) {
        this.patientServiceProxy = patientServiceProxy;
    }

    @RequestMapping("/")
    public String home (Model model) {
        return "home";
    }

    @RequestMapping("/list")
    public String patientList (Model model) {
        List<PatientBean> patientBeanList = patientServiceProxy.listeDesPatients();
        model.addAttribute("patients", patientBeanList);
        return "patientList";
    }

    @RequestMapping("/patient")
    public String patientById (Model model) {
        return "patient";
    }

}
