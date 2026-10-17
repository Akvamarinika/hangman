package com.akvamarinika.hangman.ui.dto;

import java.util.Set;

public record SnapshotGame(
        String maskedWord,
        int lives,
        Set<Character> usedLetters) {
}
