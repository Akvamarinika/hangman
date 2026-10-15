package com.akvamarinika.hangman.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Word {
    private final List<Letter> stateWord;

    public Word(String secretWord) {
        this.stateWord = createMask(secretWord);
    }

    private List<Letter> createMask(String secretWord) {
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

    public String getSecretWord() {
        return stateWord.stream()
                .map(letter -> String.valueOf(letter.getValue()))
                .collect(Collectors.joining());
    }

    public String getMaskedWorld(char hideSymbol){
        StringBuilder sb = new StringBuilder(stateWord.size());
        for (Letter letter : stateWord) {
            if (letter.isSolved()){
                sb.append(letter.getValue());
            } else {
                sb.append(hideSymbol);
            }
        }
        return sb.toString();
    }
}
