package com.akvamarinika.hangman.provider;

import java.nio.file.Path;

public class WordSourceException extends RuntimeException {
    private final Path path;

    public WordSourceException(Path path, Throwable cause) {
        super("Failed to read word source: " + path.toAbsolutePath(), cause);
        this.path = path;
    }

    public Path getPath() {
        return path;
    }
}
