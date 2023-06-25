package com.mediscreen.patientnotes.web;

import com.mediscreen.patientnotes.model.Note;
import com.mediscreen.patientnotes.service.NoteService;
import com.mediscreen.patientnotes.web.exceptions.NoNoteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping("/all")
    public List<Note> listAllNotes () {
        log.info("Get all notes");
        return noteService.getAllNotes();
    }

    @GetMapping("/patient")
    public List<Note> listNotesByPatientId (@RequestParam("patientId") String patientId) {
        log.info("Get notes for patient by id {}", patientId);
        return noteService.listNotesByPatientId(patientId);
    }

    @PostMapping("/add")
    public Note addNote(@RequestBody Note noteToAdd) throws Exception {
        log.info("Add new note");
        return noteService.addNote(noteToAdd);
    }

    @PutMapping("/update")
    public Note updateNote(@RequestParam("id") String id,
                           @RequestBody Note noteToUpdate) throws NoNoteException {
        Note noteUpdated = noteService.noteById(id);
        //noteUpdated.setPatientId(noteToUpdate.getPatientId());
        noteUpdated.setContent(noteToUpdate.getContent());
        return noteService.addNote(noteUpdated);
    }

}
