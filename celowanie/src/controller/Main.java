package controller;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import view.MainGUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage.setTitle("Aiming Arrows");
            GameController gameController = new GameController();
            MainGUI mainGUI = new MainGUI();
            BorderPane borderPane = new BorderPane();

            Scene myScene = new Scene(borderPane, 800, 600);

            borderPane.setTop(null);
            borderPane.setRight(null);

            stage.setScene(myScene);
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}