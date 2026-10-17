package com.akvamarinika.hangman.factory;

import com.akvamarinika.hangman.model.Game;
import com.akvamarinika.hangman.model.Word;
import com.akvamarinika.hangman.provider.WordProvider;

public class GameFactory {
    private final WordProvider wordProvider;

    public GameFactory(WordProvider wordProvider) {
        this.wordProvider = wordProvider;
    }

    public Game createNewGame(){
        String secretWord = wordProvider.getRandomWord();
        Word word = new Word(secretWord);
        return new Game(word);
    }
}
