package components.gameObjects;

import components.abstracts.Element;

public class Cell extends Element {

    private int value;

    public Cell(int cordX, int cordY, int value) {
        this.value = value;
        setCordX(cordX);
        setCordY(cordY);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


