package com.akvamarinika.hangman.model;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private static final int LIVES = 6;
    private final Set<Character> usedLetters = new HashSet<>();
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

    public GameMoveResult guessLetter(char letter) {
        if (isUsedLetter(letter)) {
            return GameMoveResult.USED_LETTER;
        }

        boolean hasLetter = word.openLetter(letter);
        if (!hasLetter) {
            this.loseLife();
        }

        usedLetters.add(letter);
        return hasLetter ? GameMoveResult.CORRECT_LETTER : GameMoveResult.WRONG_LETTER;
    }

    public Set<Character> getUsedLetters() {
        return usedLetters;
    }

    public String getSecretWord(){
        return word.getSecretWord();
    }

    public boolean isWin() {
        return word.isOpened();
    }

    public boolean isLose() {return livesCount == 0;}

    public boolean isGameOver() {
        return  isWin() || isLose();
    }

    private int loseLife() {
        return --livesCount;
    }

    private boolean isUsedLetter(char letter) {
        return usedLetters.contains(letter);
    }
}
