package main.java.com.akvamarinika.hangman.core;

import main.java.com.akvamarinika.hangman.model.Game;
import main.java.com.akvamarinika.hangman.model.GameMoveResult;
import main.java.com.akvamarinika.hangman.model.GameState;
import main.java.com.akvamarinika.hangman.model.Word;
import main.java.com.akvamarinika.hangman.provider.WordProvider;
import main.java.com.akvamarinika.hangman.ui.GameUI;
import main.java.com.akvamarinika.hangman.ui.Menu;

public class GameRunner {
    private final GameUI gameUI;
    private final WordProvider wordProvider;

    public GameRunner(GameUI gameUI, WordProvider wordProvider) {
        this.gameUI = gameUI;
        this.wordProvider = wordProvider;
    }

    public void run() {
        Menu menu = Menu.UNKNOWN;

        while (menu != Menu.EXIT) {
            gameUI.displayMenu();
            menu = gameUI.readMenuCommand();
            if (menu == Menu.NEW_GAME) {
                gameStart();
            }
        }
    }

    private void gameStart() {
        String secretWord = wordProvider.chooseWordRandom();
        Word word = new Word(secretWord);
        Game game = new Game(word);

        while (game.getState() == GameState.CONTINUE) {
            gameUI.displayWordMask(game.getStateWord());
            gameUI.displayLives(game.getCountLives());
            char letter = gameUI.readLetter();
            GameMoveResult gameMoveResult = game.guessLetter(letter);

            if (gameMoveResult == GameMoveResult.USED_LETTER){
                gameUI.printAlreadyUsed(letter);
            }

            gameUI.displayGameResult(game.getState());
        }
    }
}
