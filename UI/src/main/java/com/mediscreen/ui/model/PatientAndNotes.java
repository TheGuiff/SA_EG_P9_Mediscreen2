package com.mediscreen.ui.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PatientAndNotes {

    private LocalDate birthdate;
    private String gender;
    private List<String> notes;

    public PatientAndNotes (Patient patient, List<Note> notes) {
        if (patient.getBirthdate()!=null) {
            this.birthdate = LocalDate.parse(patient.getBirthdate());
        }
        this.gender = patient.getGender();
        if (notes != null) {
            this.notes = notes.stream().map(note -> note.getContent()).collect(Collectors.toList());
        } else this.notes = new ArrayList<>();
    }

}
