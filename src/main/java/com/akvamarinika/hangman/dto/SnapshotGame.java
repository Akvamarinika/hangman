package com.akvamarinika.hangman.dto;

import com.akvamarinika.hangman.model.Game;

import java.util.Set;

public record SnapshotGame(
        String maskedWord,
        int lives,
        Set<Character> usedLetters) {

    public static SnapshotGame from(Game game, char hideSymbol) {
        return new SnapshotGame(
                game.getMaskedWord(hideSymbol),
                game.getLivesCount(),
                game.getUsedSymbols()
        );
    }
}
