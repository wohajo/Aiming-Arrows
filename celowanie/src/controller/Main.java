package controller;

import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage.setTitle("Aiming Arrows");
            GameController gameController = new GameController();
            Scene myScene;
            myScene = new Scene(gameController.getMainGUI(), 800, 600);

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