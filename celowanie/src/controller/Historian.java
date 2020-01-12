package controller;

import java.io.Serializable;

public class Historian implements Serializable {

    int [] arrowClickCounters;
    int [][] currentGameBoard;

    public Historian(int [] arrowsClickCounters, int [][] currentGameBoard) {
        this.arrowClickCounters = arrowsClickCounters;
        this.currentGameBoard = currentGameBoard;
    }

    public int[][] getCurrentGameBoard() {
        return currentGameBoard;
    }

    public int[] getArrowClickCounters() {
        return arrowClickCounters;
    }
}
