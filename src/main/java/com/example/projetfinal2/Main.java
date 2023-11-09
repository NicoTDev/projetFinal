package com.example.projetfinal2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }


    public double algo(String s) {
        ArrayList<String> items = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String element : s.split(" ") ) {
            try {
                Double.parseDouble(element);
                items.add(element);
            } catch (Exception e) {
                stack.add(element);
            }
        }

        return 1;
    }

}