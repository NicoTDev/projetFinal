package com.example.projetfinal2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Currency;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        System.out.println(MathArtisanal.calculer("( cos ( 5 + 1 ) + arcsin ( 0.5 ) x ²√ ( 5 ) ) x 5", false,0));
        System.out.println(MathArtisanal.calculer("cos ( 5 + 1 ) + arcsin ( 0.5 ) x ²√ ( 5 )", true,0));
    }

    public static void main(String[] args) {
        launch();
    }

}