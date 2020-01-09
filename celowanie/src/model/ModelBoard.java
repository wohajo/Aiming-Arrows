package model;

import components.abstracts.Board;

import java.lang.reflect.Array;

public class ModelBoard extends Board {

    int[][] defaultSolutionBoard  = {
            {3, 3, 6, 2, 3},
            {5, 4, 3, 2, 4},
            {5, 2, 2, 0, 3},
            {2, 2, 3, 0, 2},
            {4, 3, 5, 3, 6}
    };

    int[][] startGameBoard = {
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4}};

    int[][] currentSolutionBoard = {
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4}};

    int[][] currentGameBoard = {
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4}};

    int[][] newSolutionBoard = new int[5][5];

    public ModelBoard(int dimX, int dimY) {
        super(dimX, dimY);
    }

    public int[][] getDefaultSolutionBoard() {
        return defaultSolutionBoard;
    }

    public int[][] getCurrentGameBoard() {return currentGameBoard;}

    public int[][] getStartGameBoard() {
        return startGameBoard;
    }

    public boolean checkIfGameEnd() {
        return java.util.Arrays.deepEquals(currentGameBoard, currentSolutionBoard);
    }

    public void resetCurrentGameBoard() {
        this.currentGameBoard = this.startGameBoard;
    }

    public int[][] getCurrentSolutionBoard() {
        return currentSolutionBoard;
    }
}


