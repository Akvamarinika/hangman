package com.akvamarinika.hangman.core;

import com.akvamarinika.hangman.dto.SnapshotGame;
import com.akvamarinika.hangman.model.Game;
import com.akvamarinika.hangman.model.GameMoveResult;
import com.akvamarinika.hangman.model.Word;
import com.akvamarinika.hangman.provider.WordProvider;
import com.akvamarinika.hangman.ui.GameUI;
import com.akvamarinika.hangman.ui.Menu;

public class GameRunner {
    private final GameUI gameUI;
    private final WordProvider wordProvider;

    public GameRunner(GameUI gameUI, WordProvider wordProvider) {
        this.gameUI = gameUI;
        this.wordProvider = wordProvider;
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
            SnapshotGame snapshotGame = SnapshotGame.from(game, gameUI.getMaskSymbol());
            gameUI.displayGameState(snapshotGame);
            char letter = gameUI.readLetter();
            GameMoveResult gameMoveResult = game.guessLetter(letter);

            if (gameMoveResult == GameMoveResult.USED_LETTER) {
                gameUI.displayAlreadyUsed(letter);
            }
        }

        SnapshotGame finalSnapshot = SnapshotGame.from(game, gameUI.getMaskSymbol());
        gameUI.displayGameState(finalSnapshot);

        if (game.isWin()) {
            gameUI.displayWinMessage(secretWord);
        } else {
            gameUI.displayLossMessage(secretWord);
        }
    }
}
