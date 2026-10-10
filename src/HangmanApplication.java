public class HangmanApplication {
    public static void main(String[] args){
        GameRunner gameRunner = new GameRunner(new ConsoleUI(), new WordProvider());
        gameRunner.run();
    }
}
