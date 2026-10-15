package com.akvamarinika.hangman.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Word {
    private final List<Letter> mask;

    public Word(String text) {
        this.mask = createMask(text);
    }

    private List<Letter> createMask(String text) {
        List<Letter> state = new ArrayList<>(text.length());
        for (char value : text.toCharArray()) {
            state.add(new Letter(value));
        }

        return state;
    }

    public boolean openLetter(char symbol) {
        List<Letter> matchedLetters = mask.stream()
                .filter(letter -> letter.getValue() == symbol)
                .toList();

        matchedLetters.forEach(Letter::open);

        return !matchedLetters.isEmpty();
    }

    public boolean isOpened() {
        for (Letter letter : mask) {
            if (!letter.isOpen()) {
                return false;
            }
        }
        return true;
    }

    public String getSecretWord() {
        return mask.stream()
                .map(letter -> String.valueOf(letter.getValue()))
                .collect(Collectors.joining());
    }

    public String getMaskedWorld(char hideSymbol){
        StringBuilder sb = new StringBuilder(mask.size());
        for (Letter letter : mask) {
            if (letter.isOpen()){
                sb.append(letter.getValue());
            } else {
                sb.append(hideSymbol);
            }
        }
        return sb.toString();
    }
}
