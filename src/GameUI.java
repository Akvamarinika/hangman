import java.util.List;

public interface GameUI {
    void displayMenu();
    void displayLives(int countLives);
    void displayWordMask(List<Letter> stateWord);
    void displayGameResult(GameState gameState);
    void printAlreadyUsed(char letter);
    char readLetter();
    Menu readMenuCommand();
}
