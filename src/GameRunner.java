public class GameRunner {
    private final GameUI gameUI;
    private final WordProvider wordProvider;

    GameRunner(ConsoleUI gameUI, WordProvider wordProvider) {
        this.gameUI = gameUI;
        this.wordProvider = wordProvider;
    }

    public void run() {
        Menu menu = Menu.UNKNOWN;

        while (menu != Menu.EXIT) {
            gameUI.displayMenu();
            menu = gameUI.readMenuCommand();
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
            gameUI.displayWordMask(game.getStateWord());
            gameUI.displayLives(game.getCountLives());
            char letter = gameUI.readLetter();
            GameMoveResult gameMoveResult = game.guessLetter(letter);

            if (gameMoveResult == GameMoveResult.USED_LETTER){
                gameUI.printAlreadyUsed(letter);
            }

            gameUI.displayGameResult(game.getState());
        }
    }
}
