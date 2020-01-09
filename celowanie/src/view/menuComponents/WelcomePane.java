package view.menuComponents;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class WelcomePane extends HBox {

    private Text welcomeText;

    public WelcomePane() {
        this.welcomeText = new Text("Welcome to Aiming Arrows! Click help to get \ninformations about the game and try out default board.\n" +
                "Click 'start' to start the game with default \nboard or 'load' to load a new board.");
        this.getChildren().add(welcomeText);
        this.welcomeText.setTextAlignment(TextAlignment.CENTER);
        this.setId("description");
        this.welcomeText.setStyle("-fx-fill: #ffffff");
    }

    public WelcomePane getWelcomePane() {
        return this;
    }
}
