package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class GameButton extends Button {

    public GameButton(String label, String id) {
        super(label);
        this.setPrefWidth(100);
        this.setPrefHeight(100);
        this.setId(id);
        this.setAlignment(Pos.CENTER);
    }
}
