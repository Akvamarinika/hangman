package main.java.com.akvamarinika.hangman;

import main.java.com.akvamarinika.hangman.core.GameRunner;
import main.java.com.akvamarinika.hangman.provider.FileWordProvider;
import main.java.com.akvamarinika.hangman.ui.ConsoleUI;
import main.java.com.akvamarinika.hangman.ui.GameText;
import main.java.com.akvamarinika.hangman.ui.RussianText;

public class HangmanApplication {
    public static void main(String[] args){
        try {
            GameText gameText = new RussianText();
            GameRunner gameRunner = new GameRunner(new ConsoleUI(gameText), new FileWordProvider("russian-words.txt"));
            gameRunner.run();
        } catch (Exception e) {
            System.err.println("A critical error has occurred! " + e.getMessage());
        }
    }
}
