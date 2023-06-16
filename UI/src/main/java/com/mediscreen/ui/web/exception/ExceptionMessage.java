package com.mediscreen.ui.web.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ExceptionMessage {

    private final String message;

    public ExceptionMessage (String messageIn) {
        if (messageIn == null) {
            this.message = "Undefined error";
        } else {
            List<String> stringList = List.of(messageIn.split(","));
            this.message = "Error : " + stringList.get(stringList.size() - 2).substring(10);
        }
    }

}
