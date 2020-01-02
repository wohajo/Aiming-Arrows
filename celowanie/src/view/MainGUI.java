package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;

public class MainGUI extends BorderPane {

    private static Label topLabel;

    public MainGUI() {
        topLabel = new Label("AIMING ARROWS");
        topLabel.setPadding(new Insets(10, 0, 10, 0));
        topLabel.setFont(Font.font("Cambria", 32));

        HBox topPane = new HBox();
        topPane.getChildren().add(topLabel);
        topPane.setAlignment(Pos.CENTER);
        topPane.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));

        BorderPane mainWindow = new BorderPane();
        mainWindow.setTop(topPane);
    }
}
