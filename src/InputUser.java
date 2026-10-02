import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class InputUser {
    private final static String FILE_PATH = "russian-words.txt";
    private final static char NEW_GAME = '1';
    private final static char EXIT = '2';

    public static char readLetter(){
        System.out.println(GameText.ENTER_LETTER_TEXT);
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.next().trim().toUpperCase().charAt(0);
        System.out.println(letter);
        return letter;
        //TODO: 1-исключить ввод чисел и символов
    }

    public static Menu readMenuCommand(){
        System.out.println(GameText.MENU_GAME_TEXT);
        System.out.println(GameText.MENU_EXIT_TEXT);
        Scanner scanner = new Scanner(System.in);
        char inputUser = scanner.next().trim().charAt(0);
        //TODO: 2-проверить ввод
        switch (inputUser){
            case NEW_GAME -> {
                return Menu.NEW_GAME;
            }
            case EXIT -> {
                return Menu.EXIT;
            }
            default -> {
                return Menu.UNKNOWN;
            }
        }
    }

    public static String chooseWordRandom(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH))){
            StringBuilder sb = new StringBuilder();
            int symbol = fileReader.read();
            while (symbol != -1){
                sb.append((char) symbol);
                symbol = fileReader.read();
            }
            String[] words = sb.toString().split("\n");
            Random random = new Random();
            int index = random.nextInt(words.length);
            return words[index].toUpperCase();
        } catch(IOException e){
            e.getStackTrace();
        }


        return "";
    }
}
