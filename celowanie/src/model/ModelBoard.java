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

    public Element[][] getDefaultBoard() {
        this.defaultBoard = new Element[7][7];
        int[][] numbers = {{3, 3, 6, 2, 3}, {5, 4, 3, 2, 4}, {5, 2, 2, 0, 3}, {2, 2, 3, 0, 2}, {4, 3, 5, 3, 6}};

        // filling default board with elements
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                if (x == 0 || x == 6 || y == 0 || y == 6) {
                    if ((x == 0 && y == 0) || (x == 0 && y == 6) || (x == 6 && y == 0) || (x == 6 && y == 6)) {
                        defaultBoard[x][y] = new Block(x, y);
                    } else {
                        if (y == 0) {
                            defaultBoard[x][y] = new Arrow(x, y); // upper arrows
                        } else if (x == 0) {
                            defaultBoard[x][y] = new Arrow(x, y); // left arrows
                        } else if (y == 6) {
                            defaultBoard[x][y] = new Arrow(x, y); // down arrows
                        } else {
                            defaultBoard[x][y] = new Arrow(x, y); // right arrows
                        }

                    }
                } else {
                    defaultBoard[x][y] = new Cell(x, y, 0);
                }
            }

            // setting values for cells
            /*for (int x2 = 1; x2 < 6; x2++) {
                for (int y2 = 1; y2 < 6; y2++) {
                    defaultBoard[x2][y2].setValue(numbers[x2][y2]);
                }
            }*/
        }
        return defaultBoard;
    }
}


