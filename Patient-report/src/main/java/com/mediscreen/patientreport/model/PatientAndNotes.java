package com.mediscreen.patientreport.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PatientAndNotes {

    private LocalDate birthdate;
    private String gender;
    private List<String> notes;

}
