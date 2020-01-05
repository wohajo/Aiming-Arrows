package components.gameObjects;

import components.abstracts.Element;
import javafx.geometry.Pos;

public class Block extends Element {

    private String txt;

    public Block(int cordX, int cordY) {
        String txt = "i am a block, no one shall move me";
        this.setPrefWidth(100);
        this.setPrefHeight(100);
        this.setAlignment(Pos.CENTER);
        this.setId("blockElement");
        setCordX(cordX);
        setCordY(cordY);
    }
}
