package model;

import components.abstracts.Board;
import components.abstracts.Element;
import components.gameObjects.Arrow;
import components.gameObjects.Block;
import components.gameObjects.Cell;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModelBoard extends Board {

    Element[][] defaultBoard;

    public ModelBoard(int dimX, int dimY) {
        super(dimX, dimY);
    }
}


