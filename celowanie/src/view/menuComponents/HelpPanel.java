package view.menuComponents;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class HelpPanel extends BorderPane {

    private HBox descriptionWrapper;
    private Text rulesText;

    public HelpPanel() {
        // Text
        this.rulesText = new Text(
                "The goal is to point as many arrows to a tile as the \n" +
                        "number on it shows. Rotate the arrows to complete the puzzle. \n" +
                        "You can not rotate the arrow so it points outside the board.\n" +
                        "Use mouse to click on an arrow to change it's direction, \n" +
                        "the game will check if Your solution is correct. \n" +
                        "Think of it as a some variation of sudoku.");
        rulesText.setId("description");

        // Wrapper for description
        this.descriptionWrapper = new HBox();
        this.descriptionWrapper.getChildren().add(rulesText);
        this.rulesText.setTextAlignment(TextAlignment.CENTER);
        this.descriptionWrapper.setAlignment(Pos.CENTER);
        this.descriptionWrapper.setId("rulesDescriptionWrapper");
        this.rulesText.setStyle("-fx-fill: #ffffff");

        // Setting up components
        this.setCenter(descriptionWrapper);
    }
}
