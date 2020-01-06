package view.menuComponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HelpPanel extends BorderPane {

    private VBox labelWrapper;
    private HBox descriptionWrapper;
    private Label rulesLabel;
    private Text rulesDescription;

    public HelpPanel() {
        // Text
        this.rulesDescription = new Text(
                "Each arrow sends a 'ray' which goes through " +
                        "every tile. \nThe goal is to point as many arrows to a tile as the number on it shows. \n" +
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
