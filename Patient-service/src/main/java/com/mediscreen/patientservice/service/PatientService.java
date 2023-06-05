package com.mediscreen.patientservice.service;

import com.mediscreen.patientservice.web.dto.PatientDto;
import com.mediscreen.patientservice.web.exceptions.NoPatientException;
import com.mediscreen.patientservice.model.Patient;
import com.mediscreen.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientDto getPatient(Long patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (!patient.isPresent()) throw new NoPatientException("Patient with id " + patientId + " doesn't exist");
        return new PatientDto(patient.get());
    }

    public List<PatientDto> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream()
                .map(patient -> new PatientDto(patient))
                .collect(Collectors.toList());
    }

    public PatientDto updatePatient(Long patientId, PatientDto patientDto) {
        if (patientRepository.findById(patientId).isPresent()) {
            Patient patient = new Patient(patientDto);
            patient.setPatientId(patientId);
            return new PatientDto(patientRepository.save(patient));
        } else throw new NoPatientException("The patient with id "+patientId.toString() + " doesn't exist");
    }

    public PatientDto addPatient (PatientDto patientDto) throws Exception {
        Patient patient = new Patient(patientDto);
        return new PatientDto(patientRepository.save(patient));
    }

}
