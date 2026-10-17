package com.akvamarinika.hangman.controller;

import com.akvamarinika.hangman.ui.dto.SnapshotGame;
import com.akvamarinika.hangman.model.Game;
import com.akvamarinika.hangman.factory.GameFactory;
import com.akvamarinika.hangman.model.GameMoveResult;
import com.akvamarinika.hangman.ui.GameUI;
import com.akvamarinika.hangman.ui.Menu;
import com.akvamarinika.hangman.ui.mapper.SnapshotGameMapper;

public class GameRunner {
    private final GameUI gameUI;
    private final GameFactory gameFactory;
    private final SnapshotGameMapper snapshotGameMapper;

    public GameRunner(GameUI gameUI, GameFactory gameFactory, SnapshotGameMapper snapshotGameMapper) {
        this.gameUI = gameUI;
        this.gameFactory = gameFactory;
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
        Game game = gameFactory.createNewGame();

        while (!game.isGameOver()) {
            SnapshotGame snapshotGame = snapshotGameMapper.from(game);
            gameUI.displayGameState(snapshotGame);
            char letter = gameUI.readLetter();
            GameMoveResult gameMoveResult = game.guessLetter(letter);

            if (gameMoveResult == GameMoveResult.USED_LETTER) {
                gameUI.displayAlreadyUsed(letter);
            }
        }

        String secretWord = game.getSecretWord();
        SnapshotGame finalSnapshot = snapshotGameMapper.from(game);
        gameUI.displayGameState(finalSnapshot);

        if (game.isWin()) {
            gameUI.displayWinMessage(secretWord);
        } else {
            gameUI.displayLossMessage(secretWord);
        }
    }
}
