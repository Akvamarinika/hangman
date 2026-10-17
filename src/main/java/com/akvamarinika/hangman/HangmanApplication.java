package com.akvamarinika.hangman;

import com.akvamarinika.hangman.controller.GameRunner;
import com.akvamarinika.hangman.factory.GameFactory;
import com.akvamarinika.hangman.provider.FileWordProvider;
import com.akvamarinika.hangman.provider.WordSourceException;
import com.akvamarinika.hangman.ui.ConsoleUI;
import com.akvamarinika.hangman.ui.GameText;
import com.akvamarinika.hangman.ui.RussianText;
import com.akvamarinika.hangman.ui.mapper.SnapshotGameMapper;

public class HangmanApplication {
    public static void main(String[] args) {
        GameText gameText = new RussianText();

        try {
            start(gameText);
        } catch (WordSourceException e) {
            System.err.printf(gameText.getDictionaryErrorTemplate(), e.getPath().toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Произошла критическая ошибка.");
            e.printStackTrace(System.err);
        }
    }

    public static void start(GameText gameText) {
        SnapshotGameMapper snapshotGameMapper = new SnapshotGameMapper();
        GameFactory gameFactory = new GameFactory(new FileWordProvider("russian-words.txt"));
        GameRunner gameRunner = new GameRunner(new ConsoleUI(gameText), gameFactory, snapshotGameMapper);
        gameRunner.execute();
    }
}
