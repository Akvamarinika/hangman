package com.akvamarinika.hangman.model;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private static final int LIVES = 6;
    private final Set<Character> usedLetters = new HashSet<>();
    private final Word word;
    private int livesCount;
    private GameState state;

    public Game(Word word) {
        this.word = word;
        this.livesCount = LIVES;
        this.state = GameState.CONTINUE;
    }

    public int getLivesCount() {
        return livesCount;
    }

    public String getMaskedWord(char hideSymbol) {
        return word.getMaskedWorld(hideSymbol);
    }

    public GameState getState() {
        return state;
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
        this.updateState();
        return hasLetter ? GameMoveResult.CORRECT_LETTER : GameMoveResult.WRONG_LETTER;
    }

    public Set<Character> getUsedLetters() {
        return usedLetters;
    }

    public String getSecretWord(){
        return word.getSecretWord();
    }

    private int loseLife() {
        return --livesCount;
    }

    private boolean isUsedLetter(char letter) {
        return usedLetters.contains(letter);
    }

    private void updateState() {
        if (livesCount == 0) {
            state = GameState.LOSS;
        } else if (word.isSolved()) {
            state = GameState.WIN;
        }
    }
}
