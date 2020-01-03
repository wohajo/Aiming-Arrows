package components.abstracts;

import java.lang.reflect.Array;
import java.util.List;

public abstract class Board {

    private int dimX;
    private int dimY;
    private Element[][] boardElements;

    public Board(int dimX, int dimY) {
        setDimX(dimX);
        setDimY(dimY);
        boardElements = new Element[dimX][dimY];
    }
    public void setDimX(int dimX) {
        this.dimX = dimX;
    }
    public void setDimY(int dimY) {
        this.dimY = dimY;
    }
    public int getDimX() {
        return dimX;
    }
    public int getDimY() {
        return dimY;
    }
}
