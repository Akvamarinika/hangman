package com.akvamarinika.hangman.ui;

public record RussianText() implements GameText {

    @Override
    public String getSingleLetterPattern() {
        return "^[а-яА-ЯёЁ]$";
    }

    @Override
    public String getMultipleLetterPattern() {
        return "^[а-яА-ЯёЁ]{2,}$";
    }

    @Override
    public String getDictionaryErrorTemplate() {
        return "Не удалось загрузить словарь слов. Проверьте файл: %s\n\n";
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
    public String getInvalidMenuChoiceTemplate(){
        return "Неверный выбор. Пожалуйста, выберите пункт из меню (например, 1 или 2).\n\n";
    }

    @Override
    public String getTooManySymbolsTemplate(){
        return "'%s' - неверный ввод. Пожалуйста, введите только одну русскую букву.\n";
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
