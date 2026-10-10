package main.java.com.akvamarinika.hangman.ui;

public class GameText {
    //public static final String LOSE_TEXT = "Вы проиграли! Слово было: ";
    public static final String LOSE_TEXT = "❌❌❌ Вы проиграли! ❌❌❌";
    public static final String WIN_TEXT = "🎉🎉🎉 Вы выиграли! 🎉🎉🎉";
    public static final String ENTER_LETTER_TEXT = "Введите букву:";
    public static final String LIVES_TEXT = "\nВаши жизни: ";
    public static final String INVALID_CYRILLIC_LETTER = "не является русской буквой. Введите букву:";
    public static final String ALREADY_USED_LETTER = "Вы уже вводили букву '%c'. Попробуйте другую!%n";
    public static final String GAME_MENU =
            """
                 ╔══════════════════════════╗
                 ║       HANGMAN GAME       ║
                 ╠══════════════════════════╣
                 ║  1. Новая игра           ║
                 ║  2. Выйти                ║
                 ╚══════════════════════════╝
                 Выберите действие:\s""";
}
