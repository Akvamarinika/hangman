package com.akvamarinika.hangman.ui;

import com.akvamarinika.hangman.model.Game;
import com.akvamarinika.hangman.model.GameState;

public interface GameUI {
    void displayGameState(Game game);
    void displayMenu();
    void displayGameResult(GameState gameState, String secretWord);
    void displayInvalidMenuChoice();
    void displayAlreadyUsed(char letter);
    char readLetter();
    Menu readMenuCommand();


}
