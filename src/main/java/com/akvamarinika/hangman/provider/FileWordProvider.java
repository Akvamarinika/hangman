package com.akvamarinika.hangman.provider;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class FileWordProvider implements WordProvider {
    public static final String ERROR_READ_FILE = "Failed to open file containing words at specified path '%s'. The program will terminate.";
    private final String filePath;
    private final Random random;

    public FileWordProvider(String filePath) {
        this.filePath = filePath;
        this.random = new Random();
    }

    public String chooseWordRandom() {
        List<String> words = readFile();
        int index = random.nextInt(words.size());
        return words.get(index).toUpperCase();
    }

    private List<String> readFile() {
        Path path = Path.of(filePath);
        try (BufferedReader fileReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            return fileReader.lines().toList();
        } catch (IOException e) {
            String absolutePath = path.toAbsolutePath().toString();
            throw new UncheckedIOException(ERROR_READ_FILE.formatted(absolutePath), e);
        }
    }
}
