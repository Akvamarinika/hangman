package com.akvamarinika.hangman.ui;

import com.akvamarinika.hangman.dto.SnapshotGame;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConsoleUI implements GameUI{
    private static final String SYMBOL_LIVE = "❤️";
    private static final char SYMBOL_CLOSED_LETTER = '_';
    private static final String NEW_GAME = "1";
    private static final String EXIT = "2";
    private final GameText gameText;
    private final Pattern singleCyrillicPattern;
    private final Pattern multipleCyrillicPattern;
    private final Scanner scanner;

    public ConsoleUI(GameText gameText) {
        this.gameText = gameText;
        this.singleCyrillicPattern = Pattern.compile(gameText.getSingleLetterPattern());
        this.multipleCyrillicPattern = Pattern.compile(gameText.getMultipleLetterPattern());
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayGameState(SnapshotGame snapshotGame) {
        this.displayWordMask(snapshotGame.maskedWord());
        this.displayLives(snapshotGame.lives());
        this.displayUsedLetters(snapshotGame.usedLetters());
        this.displayHangmanArt(snapshotGame.lives());
    }

    @Override
    public void displayMenu() {
        System.out.print(gameText.getMenuTemplate());
    }

    @Override
    public void displayWinMessage(String secretWord) {System.out.printf(gameText.getWinTemplate(), secretWord);}

    @Override
    public void displayLossMessage(String secretWord) {System.out.printf(gameText.getLoseTemplate(), secretWord);}

    @Override
    public void displayInvalidMenuChoice() {
        System.out.printf(gameText.getInvalidMenuChoiceTemplate());
    }

    @Override
    public void displayAlreadyUsed(char letter){
        System.out.printf(gameText.getAlreadyUsedTemplate(), letter);
    }

    @Override
    public char readLetter() {
        while (true) {
            System.out.print(gameText.getInputPromptTemplate());
            String inputLetter = scanner.nextLine().trim().toUpperCase();
            SymbolInputResult symbolInputResult = validate(inputLetter);

            switch (symbolInputResult){
                case VALID -> {
                    return inputLetter.charAt(0);
                }
                case MULTIPLE_CYRILLIC_SYMBOLS ->  System.out.printf(gameText.getTooManySymbolsTemplate(), inputLetter);
                case INVALID_SYMBOL -> System.out.printf(gameText.getInvalidLetterTemplate(), inputLetter);
            }
        }
    }

    @Override
    public Menu readMenuCommand() {
        String inputMenuNumber = scanner.nextLine().trim();

        return switch (inputMenuNumber) {
            case NEW_GAME -> Menu.NEW_GAME;
            case EXIT -> Menu.EXIT;
            default -> Menu.UNKNOWN;
        };
    }

    @Override
    public char getMaskSymbol() {
        return SYMBOL_CLOSED_LETTER;
    }

    private void displayLives(int countLives) {
        System.out.printf(gameText.getLivesTemplate(), SYMBOL_LIVE.repeat(countLives));
    }

    private void displayHangmanArt(int countLives){
        String art = HangmanArt.getArt(countLives);
        System.out.println(art);
    }

    private void displayWordMask(String maskWord) {
        String formatedMask = String.join(" ", maskWord.split(""));
        System.out.printf(gameText.getSecretWordTemplate(), formatedMask);
    }

    private void displayUsedLetters(Set<Character> usedLetters){
        String formattedLetters = usedLetters.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.printf(gameText.getUsedLettersTemplate(), formattedLetters);
    }

    private SymbolInputResult validate(String letter){
        if (multipleCyrillicPattern.matcher(letter).matches()){
            return SymbolInputResult.MULTIPLE_CYRILLIC_SYMBOLS;
        }

        if (singleCyrillicPattern.matcher(letter).matches()){
            return SymbolInputResult.VALID;
        }

        return SymbolInputResult.INVALID_SYMBOL;
    }
}
