package com.akvamarinika.hangman;

import com.akvamarinika.hangman.core.GameRunner;
import com.akvamarinika.hangman.provider.FileWordProvider;
import com.akvamarinika.hangman.provider.WordSourceException;
import com.akvamarinika.hangman.ui.ConsoleUI;
import com.akvamarinika.hangman.ui.GameText;
import com.akvamarinika.hangman.ui.RussianText;

public class HangmanApplication {
    public static void main(String[] args) {
        GameText gameText = new RussianText();

        try {
            GameRunner gameRunner = new GameRunner(new ConsoleUI(gameText), new FileWordProvider("russian-words.txt"));
            gameRunner.run();
        } catch (WordSourceException e) {
            System.err.printf(gameText.getDictionaryErrorTemplate(), e.getPath().toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Произошла критическая ошибка.");
            e.printStackTrace(System.err);
        }
    }
}
