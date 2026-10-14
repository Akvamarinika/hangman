package com.akvamarinika.hangman.ui;

public interface GameText {
    String getRegexPattern();

    String getLoseTemplate();
    String getWinTemplate();
    String getInvalidMenuChoiceTemplate();
    String getInvalidLetterTemplate();
    String getAlreadyUsedTemplate();
    String getMenuTemplate();
    String getInputPromptTemplate();
    String getUsedLettersTemplate();
    String getSecretWordTemplate();
    String getLivesTemplate();
}
