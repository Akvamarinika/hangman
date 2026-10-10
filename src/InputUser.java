import java.util.Scanner;
import java.util.regex.Pattern;

public class InputUser {
    private static final char NEW_GAME = '1';
    private static final char EXIT = '2';
    private static final String LETTER_PATTERN = "[а-яА-ЯёЁ]";
    private static final Pattern pattern = Pattern.compile(LETTER_PATTERN);
    private final Scanner scanner;

    public InputUser() {
        this.scanner = new Scanner(System.in);
    }

    public char readLetter() {
        while (true) {
            String inputLetter = scanner.next().trim().toUpperCase();

            if (validate(inputLetter)) {
                return inputLetter.charAt(0);
            }
        }
    }

    private boolean validate(String letter){
        return pattern
                .matcher(letter)
                .matches();
    }

    public Menu readMenuCommand() {
        char inputMenuNumber = scanner.next().trim().charAt(0);

        return switch (inputMenuNumber) {
            case NEW_GAME -> Menu.NEW_GAME;
            case EXIT -> Menu.EXIT;
            default -> Menu.UNKNOWN;
        };
    }
}
