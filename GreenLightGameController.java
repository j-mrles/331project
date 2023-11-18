import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class GreenLightGameController {

    @FXML
    private Label DifficlultyLabel;

    @FXML
    private Button EasyLevelButton;

    @FXML
    private Label GuessLabel;

    @FXML
    private TextField GuessTextField;

    @FXML
    private Button HardBLevelButton;

    @FXML
    private Label HintLabel;

    @FXML
    private TextArea HintTextArea;

    @FXML
    private Button MedimLevelButton;

    @FXML
    private TextArea ResultWindowArea;

    @FXML
    private ImageView SkyPicture;
    @FXML
    private AnchorPane anchorPane;


    @FXML
    private Button checkAnswerButton;

    @FXML
    private ImageView fungreenimage1;

    @FXML
    private ImageView fungreenimage2;

    @FXML
    private ImageView fungreenimage3;
    // Store the correct word

    private String correctWord;
    private final List<String> easyWords = Arrays.asList("Apple", "Banana", "Cherry", "Orange", "Grape");
    private final List<String> easyDescriptions = Arrays.asList(
            "A sweet and crunchy fruit",
            "A tropical fruit with a peel",
            "A small, red fruit",
            "A citrus fruit with a tough peel",
            "A small, juicy fruit"
    );

    private final List<String> mediumWords = Arrays.asList("Elephant", "Giraffe", "Lion", "Zebra", "Kangaroo");
    private final List<String> mediumDescriptions = Arrays.asList(
            "A large mammal with a trunk",
            "A tall, long-necked animal",
            "A carnivorous big cat",
            "A striped herbivorous mammal",
            "A marsupial with a strong tail"
    );

    private final List<String> hardWords = Arrays.asList("Algorithm", "Cryptocurrency", "Artificial Intelligence", "Blockchain", "Quantum Computing");
    private final List<String> hardDescriptions = Arrays.asList(
            "A step-by-step procedure or formula for solving problems",
            "A digital or virtual form of currency that uses cryptography",
            "The simulation of human intelligence by machines",
            "A decentralized and distributed ledger technology",
            "A type of computing that takes advantage of the strange properties of quantum mechanics"
    );


    @FXML
    void EasyButtonPressed(ActionEvent event) {
        displayRandomWord(easyWords, easyDescriptions);
    }

    @FXML
    void MediumButtonPressed(ActionEvent event) {
        displayRandomWord(mediumWords, mediumDescriptions);
    }

    @FXML
    void HardButtonPressed(ActionEvent event) {
        displayRandomWord(hardWords, hardDescriptions);
    }

    private int remainingTries = 5;


    // Method to display a random word and its description
    private void displayRandomWord(List<String> words, List<String> descriptions) {
        Random random = new Random();
        int index = random.nextInt(words.size());
        correctWord = words.get(index);  // Store the correct word

        String word = words.get(index);
        String description = descriptions.get(index);

        // Display the word and description as needed
        HintTextArea.setText(description);
    }

    @FXML
    void CheckButtonPressed(ActionEvent event) {
        if (remainingTries <= 0) {
            ResultWindowArea.setText("Out of tries. Game over!");
            return;
        }

        // Get the user's input from the GuessTextField
        String userGuess = GuessTextField.getText().trim();

        // Check if the user's input matches the correct word
        if (userGuess.equalsIgnoreCase(correctWord)) {
            // The word is correct, you can add your logic here
            ResultWindowArea.setText("Correct!");
        } else {
            // The word is incorrect, decrement remainingTries and display a red circle for each incorrect guess
            remainingTries--;

            // Display a red circle emoji within the ResultWindowArea for each incorrect guess
            StringBuilder resultText = new StringBuilder();
            for (int i = 0; i < (5 - remainingTries); i++) {
                resultText.append("\uD83D\uDD34"); // Unicode for a red circle emoji
            }
            String style = "-fx-text-fill: red;";
            ResultWindowArea.setStyle(style);
            ResultWindowArea.setText(resultText.toString() + " Incorrect. Try again! Tries left: " + remainingTries);
        }
    }
}


