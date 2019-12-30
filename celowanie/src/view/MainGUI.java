package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainGUI {

    public MainGUI(Stage stage) throws FileNotFoundException {
        stage.setTitle("Aiming Arrows");

        Label topLabel = new Label("AIMING ARROWS");
        topLabel.setPadding(new Insets(10, 0, 10, 0));
        topLabel.setFont(Font.font("Cambria", 32));

        HBox topPane = new HBox();
        topPane.getChildren().add(topLabel);
        topPane.setAlignment(Pos.CENTER);
        topPane.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));

        /*MenuButton saveFileButton = new MenuButton("save", 100, "rsc/saveFile.png");
        saveFileButton.setOnAction(value ->  {
            topLabel.setText("Save game");
        });*/
        //to fix, button is empty after use of custom constructor

        ImageView loadFileImg = new ImageView(new Image(new FileInputStream("rsc/loadFile.png")));
        Button openFileButton = new Button("Load", loadFileImg);
        openFileButton.setPrefWidth(100);
        openFileButton.setOnAction(value ->  {
            //gameController.load
            topLabel.setText("Load game");
        });

        ImageView exitGameImg = new ImageView(new Image(new FileInputStream("rsc/exitGame.png")));
        Button exitGameButton = new Button("Exit", exitGameImg);
        exitGameButton.setPrefWidth(100);
        exitGameButton.setOnAction(value ->  {
            topLabel.setText("Exit game");
        });

        VBox rightPane = new VBox();
        rightPane.getChildren().addAll(openFileButton, /*saveFileButton,*/ exitGameButton);
        rightPane.setSpacing(10);
        rightPane.setPadding(new Insets(0, 20, 0, 20));
        rightPane.setAlignment(Pos.TOP_CENTER);
        rightPane.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));

        BorderPane mainWindow = new BorderPane();
        mainWindow.setRight(rightPane);
        mainWindow.setTop(topPane);
        mainWindow.setCenter(null);
        mainWindow.setAlignment(topPane, Pos.TOP_CENTER);

        Scene scene = new Scene(mainWindow, 800, 600);
        stage.setScene(scene);

        stage.show();
    }

}
