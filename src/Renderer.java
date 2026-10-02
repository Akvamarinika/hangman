import java.util.List;

public class Renderer {
    private static final String SYMBOL_LIVE = "❤️";
    private static final String SYMBOL_CLOSED_LETTER = "_";

    public void displayLives(int countLives){
        System.out.printf("%s %s\n", GameText.LIVES_TEXT, SYMBOL_LIVE.repeat(countLives));
    }

    public void displayWordMask(List<Letter> stateWord){
        StringBuilder sb = new StringBuilder(stateWord.size()*2);
        for (Letter letter : stateWord){
            if (letter.isSolved()){
                sb.append(letter.getValue()).append(" ");
            } else {
                sb.append(SYMBOL_CLOSED_LETTER).append(" ");
            }
        }

        System.out.println(sb);
    }

    public void displayResult(GameState gameState){
        switch (gameState){
            case WIN -> System.out.println(GameText.WIN_TEXT);
            case LOSS -> System.out.println(GameText.LOSE_TEXT); //  + word.getSecretWord()
            case CONTINUE -> {}
        }
    }
}
