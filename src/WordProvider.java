import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WordProvider {
    private final static String FILE_PATH = "russian-words.txt";

    public String chooseWordRandom() {
        List<String> words = readFile();
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index).toUpperCase();
    }

    private List<String> readFile() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH))) {
            return fileReader
                    .lines()
                    .toList();
        } catch (IOException e) {
            e.getStackTrace();      //TODO подумать над обработкой ошибки
        }
        return Collections.emptyList();
    }
}
