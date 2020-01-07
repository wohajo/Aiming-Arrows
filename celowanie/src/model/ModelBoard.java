package model;

import components.abstracts.Board;

public class ModelBoard extends Board {

    int[][] defaultSolutionBoard  = {{3, 3, 6, 2, 3}, {5, 4, 3, 2, 4}, {5, 2, 2, 0, 3}, {2, 2, 3, 0, 2}, {4, 3, 5, 3, 6}};
    int[][] newSolutionBoard = new int[5][5];

    public ModelBoard(int dimX, int dimY) {
        super(dimX, dimY);
    }

    public int[][] getDefaultSolutionBoard() {
        return defaultSolutionBoard;
    }
}


