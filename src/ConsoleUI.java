import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleUI implements GameUI{
    private static final String SYMBOL_LIVE = "❤️";
    private static final String SYMBOL_CLOSED_LETTER = "_";
    private static final char NEW_GAME = '1';
    private static final char EXIT = '2';
    private static final String LETTER_PATTERN = "[а-яА-ЯёЁ]";
    private static final Pattern pattern = Pattern.compile(LETTER_PATTERN);
    private final Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.print(GameText.GAME_MENU);
    }

    @Override
    public void displayLives(int countLives) {
        System.out.printf("%s %s\n", GameText.LIVES_TEXT, SYMBOL_LIVE.repeat(countLives));
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

        System.out.println(sb);
    }

    @Override
    public void displayGameResult(GameState gameState) {
        switch (gameState) {
            case WIN -> System.out.println(GameText.WIN_TEXT);
            case LOSS -> System.out.println(GameText.LOSE_TEXT); //  + word.getSecretWord()
            case CONTINUE -> {
            }
        }
    }

    @Override
    public void printAlreadyUsed(char letter){
        System.out.printf(GameText.ALREADY_USED_LETTER, letter);
    }

    @Override
    public char readLetter() {
        while (true) {
            System.out.print(GameText.ENTER_LETTER_TEXT);
            String inputLetter = scanner.next().trim().toUpperCase();

            if (validate(inputLetter)) {
                return inputLetter.charAt(0);
            }

            System.out.printf("'%s' %s", inputLetter, GameText.INVALID_CYRILLIC_LETTER);
        }
    }

    private boolean validate(String letter){
        return pattern
                .matcher(letter)
                .matches();
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
}
