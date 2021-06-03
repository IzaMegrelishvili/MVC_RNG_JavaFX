package de.uni_passau.se.mvc_rng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));

        Scene scene = new Scene(root);

        // One could use CSS to style the GUI elements
        // scene.getStylesheets().add(getClass().getResource("gui.css").toString());

        stage.setTitle("SE SS21 MVC RNG");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
