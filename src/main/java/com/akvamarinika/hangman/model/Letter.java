package main.java.com.akvamarinika.hangman.model;

public class Letter {
    private final char value;
    private boolean isSolved = false;

    public Letter(char value) {
        this.value = value;
    }

    public boolean openIfMatches(char letter) {
        if (value == letter) {
            isSolved = true;
            return true;
        }
        return false;
    }

    public char getValue() {
        return value;
    }

    public boolean isSolved() {
        return isSolved;
    }
}
