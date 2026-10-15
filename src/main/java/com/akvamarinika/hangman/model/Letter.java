package com.akvamarinika.hangman.model;

public class Letter {
    private final char value;
    private boolean isOpen;

    public Letter(char value) {
        this.value = value;
    }

    public void open() {
        isOpen = true;
    }

    public char getValue() {
        return value;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
