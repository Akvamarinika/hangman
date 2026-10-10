package main.java.com.akvamarinika.hangman.provider;

@FunctionalInterface
public interface WordProvider {
    String chooseWordRandom();
}
