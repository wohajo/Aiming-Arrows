package view.menuComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class HelpPanel extends HBox {

    private Label rulesLabel;
    private Text rulesDescription;

    public HelpPanel() {
        this.rulesLabel = new Label("RULES");
        this.rulesDescription = new Text(
                "each arrow sends a 'ray' which goes through " +
                        "every tile. The goal is to point as many arrows to a tile as the number on it shows. " +
                        "Think of it as a some variation of sudoku.");
        this.setPadding(new Insets(10, 10, 10, 10));
    }
}
