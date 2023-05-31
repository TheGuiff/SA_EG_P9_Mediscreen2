package com.mediscreen.ui.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientBean {

    private Long patientId;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String gender;
    private String address;
    private String phone;

}
