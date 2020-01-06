package model;

import components.abstracts.Board;
import components.abstracts.Element;

public class ModelBoard extends Board {

    private Element[][] defaultBoard = {};

    public ModelBoard(int dimX, int dimY) {
        super(dimX, dimY);
    }

    public Element[][] getDefaultBoard() {
        return defaultBoard;
    };
};


