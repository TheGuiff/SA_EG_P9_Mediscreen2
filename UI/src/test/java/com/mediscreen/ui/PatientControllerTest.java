package com.mediscreen.ui;

import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.proxies.PatientServiceProxy;
import com.mediscreen.ui.web.controller.PatientController;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.ui.Model;

import java.util.ArrayList;

import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PatientControllerTest {

    @MockBean
    PatientServiceProxy patientServiceProxy;

    @MockBean
    private Model model;

    @Autowired
    PatientController patientController;

    private final Patient patientTest = new Patient();

    @Test
    public void homeTest() {
        String result = patientController.home(model);
        assertEquals("home", result);
    }

    @Test
    public void patientListTest() {
        when(patientServiceProxy.getAllPatient()).thenReturn(new ArrayList<>());
        String result = patientController.patientList(model);
        assertEquals("patientList", result);
    }

    @Test
    public void updatePatientTestOk() {
        when(patientServiceProxy.getPatient(any())).thenReturn(new Patient());
        String result = patientController.updatePatient(1L, model);
        assertEquals("patient", result);
    }

    @Test
    public void updatePatientTestKo() {
        when(patientServiceProxy.getPatient(any())).thenThrow(FeignException.BadRequest.class);
        String result = patientController.updatePatient(1L, model);
        assertEquals("patientList", result);
    }

    @Test
    public void updatePatientValidateTestOk() {
        when(patientServiceProxy.updatePatient(1L,patientTest)).thenReturn(patientTest);
        String result = patientController.updatePatientValidate(1L, patientTest, model);
        assertEquals("patientList", result);
    }

    @Test
    public void updatePatientValidateTestKo() {
        when(patientServiceProxy.updatePatient(1L,patientTest)).thenThrow(FeignException.BadRequest.class);
        String result = patientController.updatePatientValidate(1L, patientTest, model);
        assertEquals("patient", result);
    }

    @Test
    public void addPatientTest() {
        String result = patientController.addPatient(model);
        assertEquals("patientAdd", result);
    }

    @Test
    public void addPatientValidateTestOk() {
        when(patientServiceProxy.addPatient(patientTest)).thenReturn(patientTest);
        String result = patientController.addPatientValidate(patientTest, model);
        assertEquals("patientList", result);
    }

    @Test
    public void addPatientValidateTestKo() {
        when(patientServiceProxy.addPatient(patientTest)).thenThrow(FeignException.BadRequest.class);
        String result = patientController.addPatientValidate(patientTest, model);
        assertEquals("patientAdd", result);
    }
}
