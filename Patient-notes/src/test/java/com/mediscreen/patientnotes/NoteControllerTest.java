package com.mediscreen.patientnotes;

import com.mediscreen.patientnotes.model.Note;
import com.mediscreen.patientnotes.repository.NoteRepository;
import com.mediscreen.patientnotes.service.NoteService;
import com.mediscreen.patientnotes.web.controller.NoteController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NoteControllerTest {

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    NoteController noteController;

    @MockBean
    NoteService noteService;

    private static Note note1 = new Note();
    private static Note note2 = new Note();
    private static List<Note> notes1 = new ArrayList<>();
    private static List<Note> notes2 = new ArrayList<>();

    @BeforeAll
    public void testsInit() {
        note1.setPatientId("1");
        note1.setContent("note du patient 1");
        note2.setPatientId("2");
        note2.setContent("note du patient 2");
        notes1.add(note1);
        notes2.add(note2);
    }

    @Test
    public void listAllNotesTest() {
        when(noteService.getAllNotes()).thenReturn(notes1);
        List<Note> noteList1 = noteController.listAllNotes();
        assertEquals(1,noteList1.size());
    }

    @Test
    public void listNotesByPatientIdTest() {
        when(noteService.listNotesByPatientId(any())).thenReturn(notes2);
        List<Note> noteList2 = noteController.listNotesByPatientId("1");
        assertEquals(1,noteList2.size());
    }
}
