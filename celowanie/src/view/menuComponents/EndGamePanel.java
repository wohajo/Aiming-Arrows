package view.menuComponents;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class EndGamePanel extends BorderPane {

    private HBox winTextWrapper;
    private Text winText;

    public EndGamePanel() {

        this.winText = new Text(
                "You have beaten the puzzle!");
        winText.setId("description");

        // Wrapper for description
        this.winTextWrapper = new HBox();
        this.winTextWrapper.getChildren().add(winText);
        this.winText.setTextAlignment(TextAlignment.CENTER);
        this.winTextWrapper.setAlignment(Pos.CENTER);
        this.winText.setId("winDescription");
        this.winText.setStyle("-fx-fill: #ffffff");

        // Setting up components
        this.setCenter(winTextWrapper);
    }
}
