public class GameRunner {
    private final Renderer renderer;

    GameRunner(Renderer renderer){
        this.renderer = renderer;
    }

    public void run(){
        Menu menu = Menu.UNKNOWN;
        while (menu != Menu.EXIT) {
            menu = InputUser.readMenuCommand();

            if (menu == Menu.NEW_GAME) {
                gameStart();
            }
        }
    }

    private void gameStart(){
        String secretWord = InputUser.chooseWordRandom();
        Word word = new Word(secretWord);
        Game game = new Game(word);

        while (game.getState() == GameState.CONTINUE){
            renderer.displayLives(game.getCountLives());
            renderer.displayWordMask(game.getStateWord());
            char letter = InputUser.readLetter();
            game.play(letter);
            renderer.displayResult(game.getState());
        }
    }
}
