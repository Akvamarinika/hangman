package com.akvamarinika.hangman.ui;

import com.akvamarinika.hangman.model.GameState;
import com.akvamarinika.hangman.model.Letter;

import java.util.List;
import java.util.Set;

public interface GameUI {
    void displayMenu();
    void displayLives(int countLives);
    void displayHangmanArt(int countLives);
    void displayWordMask(List<Letter> stateWord);
    void displayUsedLetters(Set<Character> usedLetters);
    void displayGameResult(GameState gameState, String secretWord);
    void displayAlreadyUsed(char letter);
    char readLetter();
    Menu readMenuCommand();


}
