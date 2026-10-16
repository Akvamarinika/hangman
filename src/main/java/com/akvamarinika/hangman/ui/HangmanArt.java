package com.akvamarinika.hangman.ui;

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
            |    
            |    
            |    
            |   
            |
        ============
        """
    };

    private HangmanArt() {}

    public static String getArt(int countLives) {
        return STAGES[countLives];
    }
}
