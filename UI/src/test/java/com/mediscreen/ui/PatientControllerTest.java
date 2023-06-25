package com.mediscreen.ui;

import com.mediscreen.ui.model.Note;
import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.proxies.NoteServiceProxy;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PatientControllerTest {

    @MockBean
    PatientServiceProxy patientServiceProxy;

    @MockBean
    NoteServiceProxy noteServiceProxy;

    @MockBean
    private Model model;

    @Autowired
    PatientController patientController;

    private final Patient patientTest = new Patient();

    private final Note noteTest = new Note();

    private final List<Note> notesTest = new ArrayList<>();

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

    @Test
    public void addNoteTestOk() {
        when(patientServiceProxy.getPatient(any())).thenReturn(patientTest);
        String result = patientController.addNote(model, 1L);
        assertEquals("patientAddNote", result);
    }

    @Test
    public void addNoteTestKo() {
        when(patientServiceProxy.getPatient(any())).thenThrow(FeignException.BadRequest.class);
        String result = patientController.addNote(model, 1L);
        assertEquals("patientList", result);
    }

    @Test
    public void updateNoteTestOk() {
        when(patientServiceProxy.getPatient(any())).thenReturn(patientTest);
        when(noteServiceProxy.noteById(any())).thenReturn(noteTest);
        noteTest.setPatientId("1");
        String result = patientController.updateNote("",model);
        assertEquals("patientAddNote", result);
    }

    @Test
    public void updateNoteTestKo1() {
        when(patientServiceProxy.getPatient(1L)).thenThrow(FeignException.BadRequest.class);
        when(noteServiceProxy.noteById(any())).thenReturn(noteTest);
        noteTest.setPatientId("1");
        String result = patientController.updateNote("",model);
        assertEquals("patientList", result);
    }

    @Test
    public void updateNoteTestKo2() {
        when(noteServiceProxy.noteById(any())).thenThrow(FeignException.BadRequest.class);
        when(patientServiceProxy.getPatient(1L)).thenReturn(patientTest);
        noteTest.setPatientId("1");
        String result = patientController.updateNote("",model);
        assertEquals("patientList", result);
    }

    @Test
    public void validateNoteTestOk() {
        when(patientServiceProxy.getPatient(any())).thenReturn(patientTest);
        when(noteServiceProxy.addNote(any())).thenReturn(noteTest);
        when(noteServiceProxy.listNotesByPatientId(any())).thenReturn(notesTest);
        noteTest.setPatientId("1");
        String result = patientController.validateNote(noteTest, model);
        assertEquals("patient", result);
    }

    @Test
    public void validateNoteTestKo1() {
        when(patientServiceProxy.getPatient(1L)).thenThrow(FeignException.BadRequest.class);
        when(noteServiceProxy.addNote(any())).thenReturn(noteTest);
        when(noteServiceProxy.listNotesByPatientId(any())).thenReturn(notesTest);
        noteTest.setPatientId("1");
        String result = patientController.validateNote(noteTest, model);
        assertEquals("patientAddNote", result);
    }
}
