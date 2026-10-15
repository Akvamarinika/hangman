package com.akvamarinika.hangman.ui;

public interface GameText {
    String getSingleLetterPattern();
    String getMultipleLetterPattern();

    String getDictionaryErrorTemplate();
    String getLoseTemplate();
    String getWinTemplate();
    String getInvalidMenuChoiceTemplate();
    String getTooManySymbolsTemplate();
    String getInvalidLetterTemplate();
    String getAlreadyUsedTemplate();
    String getMenuTemplate();
    String getInputPromptTemplate();
    String getUsedLettersTemplate();
    String getSecretWordTemplate();
    String getLivesTemplate();
}
