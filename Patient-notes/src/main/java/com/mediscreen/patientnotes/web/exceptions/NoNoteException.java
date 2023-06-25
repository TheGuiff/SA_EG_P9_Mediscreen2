package com.mediscreen.patientnotes.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoNoteException extends RuntimeException {
    public NoNoteException(String s) {
        super(s);
    }

    @Override
    public Throwable fillInStackTrace() {
        return null;
    }

}
