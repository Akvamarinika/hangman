package main.java.com.akvamarinika.hangman.ui;

import main.java.com.akvamarinika.hangman.model.GameState;
import main.java.com.akvamarinika.hangman.model.Letter;

import java.util.List;

public interface GameUI {
    void displayMenu();
    void displayLives(int countLives);
    void displayWordMask(List<Letter> stateWord);
    void displayGameResult(GameState gameState);
    void printAlreadyUsed(char letter);
    char readLetter();
    Menu readMenuCommand();
}
