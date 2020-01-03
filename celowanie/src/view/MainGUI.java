package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;

public class MainGUI extends BorderPane {

    private Label topLabel;
    private HBox topPane;
    private VBox rightPane;

    public MainGUI() {
        // creating top label and wrapping it with HBox
        this.topLabel = new Label("AIMING ARROWS");
        topLabel.setPadding(new Insets(10, 0, 10, 0));
        topLabel.setFont(Font.font("Roboto", 32));

        this.topPane = new HBox();
        topPane.getChildren().add(topLabel);
        topPane.setAlignment(Pos.CENTER);
        topPane.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));

        // creating and aligning buttons for menu
        MenuButton saveFileButton = new MenuButton("Save");
        saveFileButton.setOnAction(value -> {
                    topLabel.setText("Saved game");
                });

        MenuButton openFileButton = new MenuButton("Load");
        openFileButton.setOnAction(value ->  {
            topLabel.setText("Loaded game");
            });

        MenuButton exitGameButton = new MenuButton("Exit");
        exitGameButton.setOnAction(value ->  {
            System.exit(0);
            });

        this.rightPane = new VBox();
        rightPane.getChildren().addAll(openFileButton, saveFileButton, exitGameButton);
        rightPane.setSpacing(10);
        rightPane.setPadding(new Insets(0, 20, 0, 20));
        rightPane.setAlignment(Pos.TOP_CENTER);
        rightPane.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));

        // setting up how to distribute Panes
        this.setTop(topPane);
        this.setRight(rightPane);
    }
}
