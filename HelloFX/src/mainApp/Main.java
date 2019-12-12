package mainApp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane okno = new GridPane();
        Scene scena = new Scene(okno, 300, 275);

        Button closeButton = new Button("Zamknij");
        closeButton.setMinWidth(60);
        closeButton.setPrefHeight(30);
        closeButton.setOnAction(zamknij -> { stage.close(); });
        okno.add(closeButton, 0,0,1,2);

        stage.initStyle(StageStyle.UNDECORATED);

        stage.setScene(scena);
        stage.setTitle("Aiming");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
