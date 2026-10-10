package main.java.com.akvamarinika.hangman;

import main.java.com.akvamarinika.hangman.core.GameRunner;
import main.java.com.akvamarinika.hangman.provider.FileWordProvider;
import main.java.com.akvamarinika.hangman.ui.ConsoleUI;

public class HangmanApplication {
    public static void main(String[] args){
        GameRunner gameRunner = new GameRunner(new ConsoleUI(), new FileWordProvider());
        gameRunner.run();
    }
}
