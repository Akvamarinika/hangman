package main.java.com.akvamarinika.hangman.ui;

import main.java.com.akvamarinika.hangman.model.GameState;
import main.java.com.akvamarinika.hangman.model.Letter;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConsoleUI implements GameUI{
    private static final String SYMBOL_LIVE = "❤️";
    private static final String SYMBOL_CLOSED_LETTER = "_";
    private static final char NEW_GAME = '1';
    private static final char EXIT = '2';
    private final GameText gameText;
    private final Pattern pattern;
    private final Scanner scanner;

    public ConsoleUI(GameText gameText) {
        this.gameText = gameText;
        this.pattern = Pattern.compile(gameText.getRegexPattern());
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.print(gameText.getMenuTemplate());
    }

    @Override
    public void displayLives(int countLives) {
        System.out.printf(gameText.getLivesTemplate(), SYMBOL_LIVE.repeat(countLives));
    }

    public void displayHangmanArt(int countLives){
        String art = HangmanArt.getArt(countLives);
        System.out.println(art);
    }

    @Override
    public void displayWordMask(List<Letter> stateWord) {
        StringBuilder sb = new StringBuilder(stateWord.size() * 2);
        for (Letter letter : stateWord) {
            if (letter.isSolved()) {
                sb.append(letter.getValue()).append(" ");
            } else {
                sb.append(SYMBOL_CLOSED_LETTER).append(" ");
            }
        }

        System.out.printf(gameText.getSecretWordTemplate(), sb);
    }

    @Override
    public void displayGameResult(GameState gameState, String secretWord) {
        switch (gameState) {
            case WIN -> System.out.printf(gameText.getWinTemplate(), secretWord);
            case LOSS -> System.out.printf(gameText.getLoseTemplate(), secretWord);
            case CONTINUE -> {
            }
        }
    }

    @Override
    public void displayAlreadyUsed(char letter){
        System.out.printf(gameText.getAlreadyUsedTemplate(), letter);
    }

    public void displayUsedLetters(Set<Character> usedLetters){
        String formattedLetters = usedLetters.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.printf(gameText.getUsedLettersTemplate(), formattedLetters);
    }

    @Override
    public char readLetter() {
        while (true) {
            System.out.print(gameText.getInputPromptTemplate());
            String inputLetter = scanner.next().trim().toUpperCase();

            if (validate(inputLetter)) {
                return inputLetter.charAt(0);
            }

            System.out.printf(gameText.getInvalidLetterTemplate(), inputLetter);
        }
    }

    @Override
    public Menu readMenuCommand() {
        char inputMenuNumber = scanner.next().trim().charAt(0);

        return switch (inputMenuNumber) {
            case NEW_GAME -> Menu.NEW_GAME;
            case EXIT -> Menu.EXIT;
            default -> Menu.UNKNOWN;
        };
    }

    private boolean validate(String letter){
        return pattern
                .matcher(letter)
                .matches();
    }
}
