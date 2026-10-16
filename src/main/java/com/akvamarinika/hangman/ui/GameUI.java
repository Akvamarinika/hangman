package com.akvamarinika.hangman.ui;

import com.akvamarinika.hangman.dto.SnapshotGame;

public interface GameUI {
    void displayGameState(SnapshotGame snapshotGame);
    void displayMenu();
    void displayWinMessage(String secretWord);
    void displayLossMessage(String secretWord);
    void displayInvalidMenuChoice();
    void displayAlreadyUsed(char letter);
    char readLetter();
    Menu readMenuCommand();
    char getMaskSymbol();


}
