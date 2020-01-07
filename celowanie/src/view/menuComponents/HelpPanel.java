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
                "The goal is to point as many arrows to a tile as the number on it shows. \n" +
                        "Rotate the arrows to complete the puzzle. You can not rotate \nthe arrow so it points outside the board.\n" +
                        "Think of it as a some variation of sudoku.");
        rulesDescription.setId("rulesDescription");

        // Wrapper for description
        this.descriptionWrapper = new HBox();
        this.descriptionWrapper.getChildren().add(rulesDescription);
        this.descriptionWrapper.setAlignment(Pos.CENTER);
        this.descriptionWrapper.setId("rulesDescriptionWrapper");

        // Setting up components
        this.setCenter(descriptionWrapper);
    }
}
