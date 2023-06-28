package com.mediscreen.patient_report.service;

import com.mediscreen.patient_report.repository.Declencheurs;
import com.mediscreen.patient_report.model.PatientAndNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ReportService {
    
    @Autowired
    Declencheurs declencheurs;

    public String calculReport (PatientAndNotes patientAndNotes) {
        Integer nbDec = 0;
        for (String note:patientAndNotes.getNotes()){
            nbDec = nbDec + nbDeclencheurs(note);
        }
        Integer age = calculateAge(patientAndNotes.getBirthdate());
        if (nbDec>=2 && nbDec<=5 && age >= 30) {
            return "Borderline";
        } else if ((nbDec>=3 && nbDec<=4 && patientAndNotes.getGender()=="M" && age < 30) ||
                (nbDec>=4 && nbDec<=6 && patientAndNotes.getGender()=="F" && age < 30) ||
                (age >=30 && nbDec>=6 && nbDec<=7)) {
            return "In Danger";
        } else if ((nbDec>=5 && patientAndNotes.getGender()=="M" && age < 30) ||
                (nbDec>=7 && patientAndNotes.getGender()=="F" && age < 30) ||
                (age >=30 && nbDec>=8)) {
            return "Early onset";
        } else return "None";
    }

    public Integer nbDeclencheurs (String note) {
        Integer result = 0;
        for (String dec:declencheurs.getDeclencheurs()) {
            if (note.indexOf(dec)>=0) {result=result+1;}
        }
        return result;
    }

    public Integer calculateAge(LocalDate birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

}
