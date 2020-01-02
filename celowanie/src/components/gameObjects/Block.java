package components.gameObjects;

import components.abstracts.Element;

public class Block extends Element {

    private String txt;

    public Block(int cordX, int cordY) {
        String txt = "i am a block, no one shall move me";
        setCordX(cordX);
        setCordY(cordY);
    }
}
