package view.menuComponents;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class WelcomePane extends HBox {

    private Text welcomeText;

    public WelcomePane() {
        this.welcomeText = new Text("Welcome to Aiming Arrows! Click help to get \ninformations about the game and try out default board.\n" +
                "Click 'start' to start the game with default \nboard or 'load' to load a new board.");
        this.getChildren().add(welcomeText);
        this.setId("description");
    }

    public WelcomePane getWelcomePane() {
        return this;
    }
}
