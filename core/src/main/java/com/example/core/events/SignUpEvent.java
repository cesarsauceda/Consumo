package com.example.core.events;

/**
 * Created by sauceda on 24/02/18.
 */

public class SignUpEvent {

    private String token;

    public SignUpEvent(String message) {
        this.token = message;
    }

    public String getMessage() {
        return token;
    }
}

