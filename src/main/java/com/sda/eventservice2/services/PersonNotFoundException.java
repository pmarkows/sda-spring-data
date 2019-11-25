package com.sda.eventservice2.services;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException() {
    }

    public PersonNotFoundException(String message) {
        super(message);
    }
}