package main.java.com.akvamarinika.hangman.model;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private final String secretWord;
    private final List<Letter> stateWord;

    public Word(String secretWord) {
        this.secretWord = secretWord;
        this.stateWord = createMask();
    }

    private List<Letter> createMask() {
        List<Letter> state = new ArrayList<>(secretWord.length());
        for (char value : secretWord.toCharArray()) {
            state.add(new Letter(value));
        }

        return state;
    }

    public boolean makeGuessLetter(char letterUser) {
        long matchedLetters = stateWord.stream()
                .filter(letter -> letter.openIfMatches(letterUser))
                .count();
        return matchedLetters > 0;
    }

    public boolean isSolved() {
        for (Letter letter : stateWord) {
            if (!letter.isSolved()) {
                return false;
            }
        }
        return true;
    }

    public List<Letter> getStateWord() {
        return new ArrayList<>(stateWord);
    }
}
