package com.akvamarinika.hangman.ui;

import com.akvamarinika.hangman.dto.SnapshotGame;
import com.akvamarinika.hangman.model.GameState;

public interface GameUI {
    void displayGameState(SnapshotGame snapshotGame);
    void displayMenu();
    void displayGameResult(GameState gameState, String secretWord);
    void displayInvalidMenuChoice();
    void displayAlreadyUsed(char letter);
    char readLetter();
    Menu readMenuCommand();
    char getMaskSymbol();


}
