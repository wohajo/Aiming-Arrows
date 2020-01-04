package view.buttons;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class MenuButton extends Button {

    public MenuButton(String label) {
        super(label);
        this.setPrefWidth(120);
        this.setId("menuButton");
        this.setAlignment(Pos.CENTER);
    }
}
