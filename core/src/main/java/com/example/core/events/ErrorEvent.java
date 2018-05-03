package com.example.core.events;

/**
 * Created by sauceda on 24/02/18.
 */

public class ErrorEvent {

    public String message = "";
    public int code = 0;

    public ErrorEvent(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
