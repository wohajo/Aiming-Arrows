package view.menuComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class HelpPanel extends BorderPane {

    private HBox descriptionWrapper;
    private Text rulesDescription;

    public HelpPanel() {
        // Text
        this.rulesDescription = new Text(
                "The goal is to point as many arrows to a tile as the \n" +
                        "number on it shows. Rotate the arrows to complete the puzzle. \n" +
                        "You can not rotate the arrow so it points outside the board.\n" +
                        "Use mouse to click on an arrow to change it's direction, \n" +
                        "the game will check if Your solution is correct. \n" +
                        "Think of it as a some variation of sudoku.");
        rulesDescription.setId("description");

        // Wrapper for description
        this.descriptionWrapper = new HBox();
        this.descriptionWrapper.getChildren().add(rulesDescription);
        this.descriptionWrapper.setAlignment(Pos.CENTER);
        this.descriptionWrapper.setId("rulesDescriptionWrapper");

        // Setting up components
        this.setCenter(descriptionWrapper);
    }
}
