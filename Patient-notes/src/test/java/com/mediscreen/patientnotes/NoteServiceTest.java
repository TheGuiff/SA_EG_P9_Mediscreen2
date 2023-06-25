package com.mediscreen.patientnotes;

import com.mediscreen.patientnotes.model.Note;
import com.mediscreen.patientnotes.repository.NoteRepository;
import com.mediscreen.patientnotes.service.NoteService;
import com.mediscreen.patientnotes.web.exceptions.NoNoteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("test")
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NoteServiceTest {

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    NoteService noteService;

    private static String idTest;

    @BeforeEach
    public void initTests() {
        noteRepository.deleteAll();
        Note note1 = new Note();
        note1.setPatientId("1");
        note1.setContent("note du patient 1");
        Note noteSaved =  noteRepository.save(note1);
        idTest = noteSaved.getId();
    }

    @Test
    public void getAllNotesTest() {
        List<Note> notes = noteService.getAllNotes();
        assertEquals(1,notes.size());
    }

    @Test
    public void noteByIdTestOk() {
        Note note = noteService.noteById(idTest);
        assertEquals("1", note.getPatientId());
    }

    @Test
    public void noteByIdTestKo() {
        assertThrows(NoNoteException.class, () -> noteService.noteById("fff"));
    }

    @Test
    public void listNotesByPatientIdTest() {
        List<Note> notes = noteService.listNotesByPatientId("1");
        assertEquals(1,notes.size());
    }

    @Test
    public void addNoteTest() {
        Note noteToAdd = new Note();
        noteToAdd.setPatientId("2");
        noteToAdd.setContent("Note du patient 2");
        Note noteAdded = noteService.addNote(noteToAdd);
        assertEquals(2, noteRepository.findAll().size());
    }
}
