package main.java.com.akvamarinika.hangman.ui;

public class HangmanArt {
    private static final String[] STAGES = {
            """
            +----+
            |    |
            |    O
            |   /|\\
            |   / \\
            |
        ============
        """,
            """
            +----+
            |    |
            |    O
            |   /|\\
            |   / 
            |
        ============
        """,
            """
            +----+
            |    |
            |    O
            |   /|\\
            |    
            |
        ============
        """,
            """
            +----+
            |    |
            |    O
            |    |
            |   
            |
        ============
        """,
            """
            +----+
            |    |
            |    O
            |    
            |   
            |
        ============
        """,
            """
            +----+
            |    |
            |    
            |    
            |   
            |
        ============
        """,
            """
            
            
            
            
            
            
        ============
        """
    };

    private HangmanArt() {}

    public static String getArt(int countLives) {
        if (countLives < 0) {
            return STAGES[0];
        }

        if (countLives >= STAGES.length) {
            return STAGES[STAGES.length - 1];
        }

        return STAGES[countLives];
    }
}
