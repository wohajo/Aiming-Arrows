package view.menuComponents;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class EndGamePanel extends HBox {
    private Text winText;

    public EndGamePanel() {
        this.winText = new Text("YOU WON!");
        this.getChildren().add(winText);
        this.setId("winDescription");
    }

    public EndGamePanel getEndGamePane() {
        return this;
    }
}

