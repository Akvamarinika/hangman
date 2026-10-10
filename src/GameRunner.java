public class GameRunner {
    private final Renderer renderer;
    private final InputUser inputUser;
    private final WordProvider wordProvider;

    GameRunner(Renderer renderer, InputUser inputUser, WordProvider wordProvider) {
        this.renderer = renderer;
        this.inputUser = inputUser;
        this.wordProvider = wordProvider;
    }

    public void run() {
        Menu menu = Menu.UNKNOWN;

        while (menu != Menu.EXIT) {
            renderer.displayMenu();
            menu = inputUser.readMenuCommand();
            if (menu == Menu.NEW_GAME) {
                gameStart();
            }
        }
    }

    private void gameStart() {
        String secretWord = wordProvider.chooseWordRandom();
        Word word = new Word(secretWord);
        Game game = new Game(word);

        while (game.getState() == GameState.CONTINUE) {
            renderer.displayWordMask(game.getStateWord());
            renderer.displayLives(game.getCountLives());
            renderer.printEnterLetter();
            char letter = inputUser.readLetter();
            GameMoveResult gameMoveResult = game.guessLetter(letter);

            if (gameMoveResult == GameMoveResult.USED_LETTER){
                renderer.printAlreadyUsed(letter);
            }

            renderer.displayGameResult(game.getState());
        }
    }
}
