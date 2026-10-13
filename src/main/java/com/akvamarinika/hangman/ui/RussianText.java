package com.akvamarinika.hangman.ui;

public record RussianText() implements GameText {

    @Override
    public String getRegexPattern() {
        return "[а-яА-ЯёЁ]";
    }

    @Override
    public String getLoseTemplate() {
        return "❌❌❌ Вы проиграли! ❌❌❌ Загаданное слово: %s\n\n";
    }

    @Override
    public String getWinTemplate() {
        return "🎉🎉🎉 Вы выиграли! 🎉🎉🎉 Слово: %s\n\n";
    }

    @Override
    public String getInvalidLetterTemplate() {
        return "'%s' - не является русской буквой. ";
    }

    @Override
    public String getAlreadyUsedTemplate() {
        return "Вы уже вводили букву '%c'. Попробуйте другую!%n";
    }

    @Override
    public String getInputPromptTemplate() {
        return "Введите букву: ";
    }

    @Override
    public String getUsedLettersTemplate() {
        return "Ранее введенные буквы: %s\n";
    }

    @Override
    public String getSecretWordTemplate() {
        return "Загаданное слово: %s\n";
    }

    @Override
    public String getLivesTemplate() {
        return "Ваши жизни: %s\n";
    }

    @Override
    public String getMenuTemplate() {
        return             """
                 ╔══════════════════════════╗
                 ║       HANGMAN GAME       ║
                 ╠══════════════════════════╣
                 ║  1. Новая игра           ║
                 ║  2. Выйти                ║
                 ╚══════════════════════════╝
                 Выберите действие:\s""";
    }
}
