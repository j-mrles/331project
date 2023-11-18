package com.example.GreenLightGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GreenLight extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/GreenLightGame/GreenLight.fxml"));
        loader.setController(new GreenLightGameController()); // Set the controller
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Green Light Red Light Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
