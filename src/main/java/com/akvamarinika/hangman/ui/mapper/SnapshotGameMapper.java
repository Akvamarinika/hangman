package com.akvamarinika.hangman.ui.mapper;

import com.akvamarinika.hangman.ui.dto.SnapshotGame;
import com.akvamarinika.hangman.model.Game;

public class SnapshotGameMapper {
    private static final char SYMBOL_CLOSED_LETTER = '_';

    public SnapshotGame from(Game game) {
        return new SnapshotGame(
                game.getMaskedWord(SYMBOL_CLOSED_LETTER),
                game.getLivesCount(),
                game.getUsedSymbols()
        );
    }
}
