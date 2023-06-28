package com.mediscreen.patient_report.repository;

import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class Declencheurs {

    public List<String> declencheurs;

    public Declencheurs() {
        this.declencheurs = new ArrayList<>();
        this.declencheurs.add("Hémoglobine A1C");
        this.declencheurs.add("Microalbumine");
        this.declencheurs.add("Taille");
        this.declencheurs.add("Poids");
        this.declencheurs.add("Fumeur");
        this.declencheurs.add("Anormal");
        this.declencheurs.add("Cholestérol");
        this.declencheurs.add("Vertige");
        this.declencheurs.add("Rechute");
        this.declencheurs.add("Réaction");
        this.declencheurs.add("Anticorps");
    }

}
