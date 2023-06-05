package com.mediscreen.patientservice.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoPatientException extends RuntimeException {
    public NoPatientException(String message) {
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }

}
