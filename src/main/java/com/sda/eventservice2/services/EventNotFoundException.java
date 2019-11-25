package com.sda.eventservice2.services;

public class EventNotFoundException extends Exception {
    public EventNotFoundException() {
    }

    public EventNotFoundException(String message) {
        super(message);
    }
}