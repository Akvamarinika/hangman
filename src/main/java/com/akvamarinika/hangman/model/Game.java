package main.java.com.akvamarinika.hangman.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private static final int LIVES = 6;
    private final Set<Character> usedLetters = new HashSet<>();
    private final Word word;
    private int countLives;
    private GameState state;

    public Game(Word word) {
        this.word = word;
        this.countLives = LIVES;
        this.state = GameState.CONTINUE;
    }

    public int getCountLives() {
        return countLives;
    }

    public List<Letter> getStateWord() {
        return new ArrayList<>(word.getStateWord());
    }

    public GameState getState() {
        return state;
    }

    public GameMoveResult guessLetter(char letter) {
        if (alreadyNamed(letter)) {
            return GameMoveResult.USED_LETTER;
        }

        boolean hasLetter = word.makeGuessLetter(letter);
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
        return countLives--;
    }

    private boolean alreadyNamed(char letter) {
        return usedLetters.contains(letter);
    }

    private void updateState() {
        if (countLives == 0) {
            state = GameState.LOSS;
        } else if (word.isSolved()) {
            state = GameState.WIN;
        }
    }
}
