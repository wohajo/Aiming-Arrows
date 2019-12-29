package gameLogic.objects;

import gameLogic.abstracts.Element;

public class Cell extends Element {

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Cell(int value) {
        this.value = value;
    }
}

