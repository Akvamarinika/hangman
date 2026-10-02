import java.io.*;

public class HangmanApplication {
    public static void main(String[] args){
        GameRunner gameRunner = new GameRunner(new Renderer());
        gameRunner.run();
    }
}
