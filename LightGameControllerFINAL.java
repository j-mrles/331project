package com.example.javafxproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class LightGameController {

    @FXML
    private Label DifficlultyLabel;

    @FXML
    private Button MedimLevelButton;

    @FXML
    private Button EasyLevelButton;

    @FXML
    private Button HardBLevelButton;

    @FXML
    private Label HintLabel;

    @FXML
    private TextArea HintTextArea;

    @FXML
    private Label GuessLabel;

    @FXML
    private TextField GuessTextField;

    @FXML
    private TextArea ResultWindowArea;

    @FXML
    private Button checkAnswerButton;

    @FXML
    private ImageView fungreenimage1;

    @FXML
    private ImageView fungreenimage2;

    @FXML
    private ImageView fungreenimage3;

    private String[] wordsEasy = {"dog", "cat", "bird", "fish", "bat"};
    private String[] wordsMedium = {"elephant", "zebra", "giraffe", "kangaroo", "rhinoceros"};
    private String[] wordsHard = {"programming", "algorithm", "java", "python", "developer"};

    private String currentWord;
    private StringBuilder guessedWord;
    private int remainingAttempts;

    @FXML
    private void MediumButtonPressed() {
        startGame(wordsMedium);
    }

    @FXML
    private void EasyButtonPressed() {
        startGame(wordsEasy);
    }

    @FXML
    private void HardButtonPressed() {
        startGame(wordsHard);
    }

    @FXML
    private void CheckButtonPressed() {
        String guessedLetter = GuessTextField.getText().toLowerCase();

        if (guessedLetter.length() == 1 && guessedLetter.matches("[a-z]")) {
            checkGuess(guessedLetter.charAt(0));
        } else {
            ResultWindowArea.setText("Invalid input. Please enter a single letter.");
        }

        GuessTextField.clear();
    }

    private void startGame(String[] wordList) {
        currentWord = wordList[(int) (Math.random() * wordList.length)];
        remainingAttempts = 6;
        guessedWord = new StringBuilder("_".repeat(currentWord.length()));

        HintTextArea.setText("Hint: This word has " + currentWord.length() + " letters.");
        ResultWindowArea.setText("Game started! Remaining attempts: " + remainingAttempts);
    }

    private void checkGuess(char guessedLetter) {
        boolean correctGuess = false;

        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == guessedLetter) {
                guessedWord.setCharAt(i, guessedLetter);
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            remainingAttempts--;
        }

        updateUI();

        if (guessedWord.toString().equals(currentWord)) {
            ResultWindowArea.setText("Congratulations! You guessed the word: " + currentWord);
        } else if (remainingAttempts <= 0) {
            ResultWindowArea.setText("Game over! The correct word was: " + currentWord);
        }
    }

    private void updateUI() {
        ResultWindowArea.setText("Guessed word: " + guessedWord.toString() +
                "\nRemaining attempts: " + remainingAttempts);
    }
}
