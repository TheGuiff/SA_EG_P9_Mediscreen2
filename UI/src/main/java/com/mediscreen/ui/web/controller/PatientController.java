package com.mediscreen.ui.web.controller;

import com.mediscreen.ui.model.Note;
import com.mediscreen.ui.model.Patient;
import com.mediscreen.ui.model.PatientAndNotes;
import com.mediscreen.ui.proxies.NoteServiceProxy;
import com.mediscreen.ui.proxies.PatientServiceProxy;
import com.mediscreen.ui.proxies.ReportServiceProxy;
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

    @Autowired
    private final NoteServiceProxy noteServiceProxy;

    @Autowired
    private final ReportServiceProxy reportServiceProxy;

    public PatientController(PatientServiceProxy patientServiceProxy, NoteServiceProxy noteServiceProxy, ReportServiceProxy reportServiceProxy) {
        this.patientServiceProxy = patientServiceProxy;
        this.noteServiceProxy = noteServiceProxy;
        this.reportServiceProxy = reportServiceProxy;
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
                List<Note> notes = noteServiceProxy.listNotesByPatientId(Long.toString(id));
                PatientAndNotes patientAndNotes = new PatientAndNotes(patient, notes);
                String report = reportServiceProxy.report(patientAndNotes);
                model.addAttribute("notes", notes);
                model.addAttribute("id", id);
                model.addAttribute("report", report);
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
            List<Note> notes = noteServiceProxy.listNotesByPatientId(Long.toString(id));
            PatientAndNotes patientAndNotes = new PatientAndNotes(patient, notes);
            String report = reportServiceProxy.report(patientAndNotes);
            model.addAttribute("notes", notes);
            model.addAttribute("id", id);
            model.addAttribute("report", report);
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

    @GetMapping("/patient/addNote/")
    public String addNote(Model model, @RequestParam("patientId") Long patientId) {
        try {
            Note note = new Note();
            note.setPatientId(Long.toString(patientId));
            model.addAttribute("note", note);
            Patient patient = patientServiceProxy.getPatient(patientId);
            model.addAttribute("patient", patient);
            model.addAttribute("titre", "New note for patient ");
            return "patientAddNote";
        } catch (Exception e) {
            ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
            model.addAttribute("Error",exceptionMessage.getMessage());
            return "patientList";
        }
    }

    @RequestMapping("/patient/updateNote/")
    public String updateNote(@RequestParam("id") String id, Model model) {
        try {
            Note note = noteServiceProxy.noteById(id);
            model.addAttribute("note", note);
            Patient patient = patientServiceProxy.getPatient(Long.valueOf(note.getPatientId()));
            model.addAttribute("patient", patient);
            model.addAttribute("titre", "Update note for patient ");
            return "patientAddNote";
        } catch (Exception e) {
            ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
            model.addAttribute("Error",exceptionMessage.getMessage());
            List<Patient> patientList = patientServiceProxy.getAllPatient();
            model.addAttribute("patients", patientList);
            return "patientList";
        }
    }

    @PostMapping("/patient/validateNote")
    public String validateNote(Note note, Model model) {
        try {
            if (note.getId()==""){note.setId(null);}
            Note noteAdded = noteServiceProxy.addNote(note);
            List<Note> notes = noteServiceProxy.listNotesByPatientId(note.getPatientId());
            model.addAttribute("notes", notes);
            Patient patient = patientServiceProxy.getPatient(Long.valueOf(note.getPatientId()));
            model.addAttribute("patient", patient);
            PatientAndNotes patientAndNotes = new PatientAndNotes(patient, notes);
            String report = reportServiceProxy.report(patientAndNotes);
            model.addAttribute("report", report);
            return "patient";
        } catch (Exception e) {
            ExceptionMessage exceptionMessage = new ExceptionMessage(e.getMessage());
            model.addAttribute("Error",exceptionMessage.getMessage());
            return "patientAddNote";
        }

    }

}
