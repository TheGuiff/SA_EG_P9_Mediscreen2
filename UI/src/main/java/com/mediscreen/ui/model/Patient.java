package com.mediscreen.ui.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {

    private Long patientId;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String gender;
    private String address;
    private String phone;

}
