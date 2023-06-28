package com.mediscreen.patientreport;

import com.mediscreen.patientreport.model.PatientAndNotes;
import com.mediscreen.patientreport.repository.Declencheurs;
import com.mediscreen.patientreport.service.ReportService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReportServiceTest {

    @Autowired
    ReportService reportService;

    @Autowired
    Declencheurs declencheurs;

    private static PatientAndNotes patientNone = new PatientAndNotes();
    private static PatientAndNotes patientBorderline = new PatientAndNotes();
    private static PatientAndNotes patientInDanger = new PatientAndNotes();
    private static PatientAndNotes patientEarly = new PatientAndNotes();
    private static List<String> notesNone = new ArrayList<>();
    private static List<String> notesBorderline = new ArrayList<>();
    private static List<String> notesInDanger = new ArrayList<>();
    private static List<String> notesEarly = new ArrayList<>();

    @BeforeAll
    public void initReportServiceTest() {
        patientNone.setGender("M");
        patientNone.setBirthdate(LocalDate.parse("05/05/2001",DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        patientNone.setNotes(notesNone);
        patientBorderline.setGender("M");
        patientBorderline.setBirthdate(LocalDate.parse("05/05/1986",DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        notesBorderline.add(declencheurs.getDeclencheurs().get(0));
        notesBorderline.add(declencheurs.getDeclencheurs().get(1));
        patientBorderline.setNotes(notesBorderline);
        patientInDanger.setGender("M");
        patientInDanger.setBirthdate(LocalDate.parse("05/05/1986",DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        notesInDanger.add(declencheurs.getDeclencheurs().get(0));
        notesInDanger.add(declencheurs.getDeclencheurs().get(1));
        notesInDanger.add(declencheurs.getDeclencheurs().get(2));
        notesInDanger.add(declencheurs.getDeclencheurs().get(3));
        notesInDanger.add(declencheurs.getDeclencheurs().get(4));
        notesInDanger.add(declencheurs.getDeclencheurs().get(5));
        patientInDanger.setNotes(notesInDanger);
        patientEarly.setGender("M");
        patientEarly.setBirthdate(LocalDate.parse("05/05/1986",DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        notesEarly.add(declencheurs.getDeclencheurs().get(0));
        notesEarly.add(declencheurs.getDeclencheurs().get(1));
        notesEarly.add(declencheurs.getDeclencheurs().get(2));
        notesEarly.add(declencheurs.getDeclencheurs().get(3));
        notesEarly.add(declencheurs.getDeclencheurs().get(4));
        notesEarly.add(declencheurs.getDeclencheurs().get(5));
        notesEarly.add(declencheurs.getDeclencheurs().get(6));
        notesEarly.add(declencheurs.getDeclencheurs().get(7));
        patientEarly.setNotes(notesEarly);
    }


    @Test
    public void calculateAgeTest() {
        LocalDate birthdate = LocalDate.ofYearDay(LocalDate.now().getYear() - 51,1);
        assertEquals(51,reportService.calculateAge(birthdate));
    }

    @Test
    public void nbDeclencheursTest() {
        assertEquals(0,reportService.nbDeclencheurs(""));
        assertEquals(1,reportService.nbDeclencheurs(declencheurs.getDeclencheurs().get(0)));
    }

    @Test
    public void calculReportTestNone() {
        assertEquals("None", reportService.calculReport(patientNone));
    }

    @Test
    public void calculReportTestBorderline() {
        assertEquals("Borderline", reportService.calculReport(patientBorderline));
    }

    @Test
    public void calculReportTestInDanger() {
        assertEquals("In Danger", reportService.calculReport(patientInDanger));
    }
}
