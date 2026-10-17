package com.akvamarinika.hangman.dto;

import java.util.Set;

public record SnapshotGame(
        String maskedWord,
        int lives,
        Set<Character> usedLetters) {
}
