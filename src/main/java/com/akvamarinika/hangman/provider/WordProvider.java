package com.akvamarinika.hangman.provider;

@FunctionalInterface
public interface WordProvider {
    String getRandomWord();
}
