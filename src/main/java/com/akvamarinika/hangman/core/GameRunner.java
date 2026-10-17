package com.akvamarinika.hangman.core;

import com.akvamarinika.hangman.dto.SnapshotGame;
import com.akvamarinika.hangman.model.Game;
import com.akvamarinika.hangman.model.GameMoveResult;
import com.akvamarinika.hangman.model.Word;
import com.akvamarinika.hangman.provider.WordProvider;
import com.akvamarinika.hangman.ui.GameUI;
import com.akvamarinika.hangman.ui.Menu;
import com.akvamarinika.hangman.ui.mapper.SnapshotGameMapper;

public class GameRunner {
    private final GameUI gameUI;
    private final WordProvider wordProvider;
    private final SnapshotGameMapper snapshotGameMapper;

    public GameRunner(GameUI gameUI, WordProvider wordProvider, SnapshotGameMapper snapshotGameMapper) {
        this.gameUI = gameUI;
        this.wordProvider = wordProvider;
        this.snapshotGameMapper = snapshotGameMapper;
    }

    public void execute() {
        while (true) {
            gameUI.displayMenu();
            Menu menu = gameUI.readMenuCommand();

            switch (menu) {
                case NEW_GAME -> startGame();
                case EXIT -> {
                    return;
                }
                case UNKNOWN -> gameUI.displayInvalidMenuChoice();
            }
        }
    }

    private void startGame() {
        String secretWord = wordProvider.getRandomWord();
        Word word = new Word(secretWord);
        Game game = new Game(word);

        while (!game.isGameOver()) {
            SnapshotGame snapshotGame = snapshotGameMapper.from(game);
            gameUI.displayGameState(snapshotGame);
            char letter = gameUI.readLetter();
            GameMoveResult gameMoveResult = game.guessLetter(letter);

            if (gameMoveResult == GameMoveResult.USED_LETTER) {
                gameUI.displayAlreadyUsed(letter);
            }
        }

        SnapshotGame finalSnapshot = snapshotGameMapper.from(game);
        gameUI.displayGameState(finalSnapshot);

        if (game.isWin()) {
            gameUI.displayWinMessage(secretWord);
        } else {
            gameUI.displayLossMessage(secretWord);
        }
    }
}
