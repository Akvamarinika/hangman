package com.akvamarinika.hangman.provider;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class FileWordProvider implements WordProvider {
    private final String filePath;
    private final Random random;

    public FileWordProvider(String filePath) {
        this.filePath = filePath;
        this.random = new Random();
    }

    public String getRandomWord() {
        List<String> words = readFile();
        int index = random.nextInt(words.size());
        return words.get(index).toUpperCase();
    }

    private List<String> readFile() {
        Path path = Path.of(filePath);

        try (BufferedReader fileReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            return fileReader.lines().toList();
        } catch (IOException e) {
            throw new WordSourceException(path, e);
        }
    }
}
