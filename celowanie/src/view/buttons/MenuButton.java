package view.buttons;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class MenuButton extends Button {

    private boolean isClicked = false;

    public MenuButton(String label) {

        super(label);
        this.setPrefWidth(120);
        this.setId("menuButton");
        this.setAlignment(Pos.CENTER);
    }

    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    public boolean getIsClicked() {
        return this.isClicked;
    }
}
