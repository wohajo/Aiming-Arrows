package view.menuComponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TopPane extends HBox {

    private HBox topPane;
    private Label topLabel;

    public TopPane() {
        this.topLabel = new Label("Aiming arrows");
        this.topLabel.setPadding(new Insets(10, 0, 10, 0));
        this.topLabel.setFont(Font.font("Roboto", 32));

        this.topPane = new HBox();
        topPane.getChildren().add(topLabel);
        topPane.setAlignment(Pos.CENTER);
        topPane.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public HBox getTopPane() {
        return topPane;
    }

    public void changeLabelText(String text) {
        this.topLabel.setText(text);
    }

    public void changeLabelToDefault() {this.topLabel.setText("Aiming arrows");}
}
