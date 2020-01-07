package components.gameObjects;

import components.abstracts.Element;
import javafx.geometry.Pos;

public class Cell extends Element {

    public Cell(int cordX, int cordY, int value) {
        setCordX(cordX);
        setCordY(cordY);
        this.setPrefWidth(100);
        this.setPrefHeight(100);
        this.setAlignment(Pos.CENTER);
        this.setId("cellElement");
        setValue(value);
    }

    public void changeLabel(int label) {
        this.setText(String.valueOf(label));
    }
}



