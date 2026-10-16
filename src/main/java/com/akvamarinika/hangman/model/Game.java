package com.akvamarinika.hangman.model;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private static final int LIVES = 6;
    private final Set<Character> usedSymbols = new HashSet<>();
    private final Word word;
    private int livesCount;

    public Game(Word word) {
        this.word = word;
        this.livesCount = LIVES;
    }

    public int getLivesCount() {
        return livesCount;
    }

    public String getMaskedWord(char hideSymbol) {
        return word.getMaskedWorld(hideSymbol);
    }

    public GameMoveResult guessLetter(char symbol) {
        if (isUsedLetter(symbol)) {
            return GameMoveResult.USED_LETTER;
        }

        boolean isCorrectGuess = word.hasLetter(symbol);
        if (word.hasLetter(symbol)) {
            word.openLetter(symbol);
        } else {
            this.loseLife();
        }

        usedSymbols.add(symbol);
        return isCorrectGuess ? GameMoveResult.CORRECT_LETTER : GameMoveResult.WRONG_LETTER;
    }

    public Set<Character> getUsedSymbols() {
        return usedSymbols;
    }

    public String getSecretWord() {
        return word.getSecretWord();
    }

    public boolean isWin() {
        return word.isOpened();
    }

    public boolean isLose() {
        return livesCount == 0;
    }

    public boolean isGameOver() {
        return isWin() || isLose();
    }

    private void loseLife() {
        --livesCount;
    }

    private boolean isUsedLetter(char letter) {
        return usedSymbols.contains(letter);
    }
}
