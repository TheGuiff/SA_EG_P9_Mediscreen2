package com.mediscreen.patientnotes.service;

import com.mediscreen.patientnotes.model.Note;
import com.mediscreen.patientnotes.repository.NoteRepository;
import com.mediscreen.patientnotes.web.exceptions.NoNoteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note noteById (String id) {
        Optional<Note> note =  noteRepository.findById(id);
        if (!note.isPresent()) throw new NoNoteException("Note with id " + id + " doesn't exist");
        return note.get();
    }

    public List<Note> listNotesByPatientId (String patientId) {
        return noteRepository.findByPatientId(patientId);
    }

    public Note addNote (Note noteToAdd) {
        return noteRepository.save(noteToAdd);
    }

}
