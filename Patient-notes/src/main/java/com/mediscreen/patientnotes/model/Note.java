package com.mediscreen.patientnotes.model;

import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "notes")
public class Note {

    @Id
    private String id;

    @Field(value="patientId")
    private String patientId;

    @Field(value = "content")
    private String content;

}
