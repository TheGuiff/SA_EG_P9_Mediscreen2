package com.mediscreen.patientnotes.repository;

import com.mediscreen.patientnotes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

    List<Note> findByPatientId (String patientId);

}
