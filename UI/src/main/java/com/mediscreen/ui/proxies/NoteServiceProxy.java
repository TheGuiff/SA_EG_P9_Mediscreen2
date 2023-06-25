package com.mediscreen.ui.proxies;

import com.mediscreen.ui.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="Patient-notes", url="localhost:8082")
public interface NoteServiceProxy {

    @GetMapping("/notes/all/")
    List<Note> listAllNotes();

    @GetMapping("/notes/patient/")
    List<Note> listNotesByPatientId(@RequestParam("patientId") String patientId);

    @PostMapping("/notes/add/")
    Note addNote(Note noteToAdd);

    @PutMapping("notes/update/")
    Note updateNote (@RequestParam("id") String id, Note noteToUpdate);

    @GetMapping("notes/byId/")
    Note noteById (@RequestParam("id") String id);

}
