package mainApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.web.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.*;
import javafx.stage.StageStyle;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage.setTitle("Aiming Arrows");

            Label topLabel = new Label("AIMING ARROWS");
            topLabel.setPadding(new Insets(10, 0, 0, 20));
            topLabel.setFont(Font.font("Cambria", 32));
            //topLabel.setBackground(new Background());

            Button openFile = new Button("Wczytaj");
            openFile.setPrefWidth(100);
            Button saveFile = new Button("Zapisz");
            saveFile.setPrefWidth(100);
            Button exitGame = new Button("Zakończ grę");
            exitGame.setPrefWidth(100);
            VBox rightPane = new VBox();
            rightPane.getChildren().addAll(openFile, saveFile, exitGame);
            rightPane.setSpacing(10);
            rightPane.setPadding(new Insets(0, 20, 0, 0));

            rightPane.setAlignment(Pos.TOP_CENTER);

            //creating main window and hooking up nodes inside
            BorderPane mainWindow = new BorderPane();
            mainWindow.setRight(rightPane);
            mainWindow.setTop(topLabel);
            mainWindow.setAlignment(topLabel, Pos.TOP_CENTER);

            Scene scene = new Scene(mainWindow, 800, 600);
            stage.setScene(scene);

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