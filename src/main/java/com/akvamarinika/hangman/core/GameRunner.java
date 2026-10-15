package com.akvamarinika.hangman.core;

import com.akvamarinika.hangman.dto.SnapshotGame;
import com.akvamarinika.hangman.model.Game;
import com.akvamarinika.hangman.model.GameMoveResult;
import com.akvamarinika.hangman.model.GameState;
import com.akvamarinika.hangman.model.Word;
import com.akvamarinika.hangman.provider.WordProvider;
import com.akvamarinika.hangman.ui.GameUI;
import com.akvamarinika.hangman.ui.Menu;

import java.util.Set;

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
                case EXIT -> { return;}
                case UNKNOWN -> gameUI.displayInvalidMenuChoice();
            }
        }
    }

    private void startGame() {
        String secretWord = wordProvider.getRandomWord();
        Word word = new Word(secretWord);
        Game game = new Game(word);

        while (game.getState() == GameState.CONTINUE) {
            SnapshotGame snapshotGame = createSnapshotGame(game, gameUI.getMaskSymbol());
            gameUI.displayGameState(snapshotGame);
            char letter = gameUI.readLetter();
            GameMoveResult gameMoveResult = game.guessLetter(letter);

            if (gameMoveResult == GameMoveResult.USED_LETTER){
                gameUI.displayAlreadyUsed(letter);
            }
        }

        SnapshotGame finalSnapshot = createSnapshotGame(game, gameUI.getMaskSymbol());
        gameUI.displayGameState(finalSnapshot);
        gameUI.displayGameResult(game.getState(), game.getSecretWord());
    }

    private SnapshotGame createSnapshotGame(Game game, char hideSymbol){
        String maskedWord = game.getMaskedWord(hideSymbol);
        int countLives = game.getLivesCount();
        Set<Character> usedSymbols = game.getUsedLetters();
        return new SnapshotGame(maskedWord, countLives, usedSymbols);
    }
}
