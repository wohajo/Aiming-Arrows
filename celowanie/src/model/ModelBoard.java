package model;

import components.abstracts.Position;
import components.gameObjects.Arrow;

public class ModelBoard {

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

    public ModelBoard() {

    }

    public void setCurrentSolutionBoardCell(int x, int y, int value) {
        this.currentSolutionBoard[x][y] = value;
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

    public void modifyGameBoardAfterMove(Arrow arrow, Position position) {

        if (position == Position.UP) {
            addOrSubtractFromGameBoardForUpperArrows(arrow, arrow.getPreviousClickcounter(), -1);
            addOrSubtractFromGameBoardForUpperArrows(arrow, arrow.getClickCounter(), 1);
        }

        else if (position == Position.DOWN) {
            addOrSubtractFromGameBoardForDownArrows(arrow, arrow.getPreviousClickcounter(), -1);
            addOrSubtractFromGameBoardForDownArrows(arrow, arrow.getClickCounter(), 1);
        }

        else if (position == Position.LEFT) {
            addOrSubtractFromGameBoardForLeftArrows(arrow, arrow.getPreviousClickcounter(), -1);
            addOrSubtractFromGameBoardForLeftArrows(arrow, arrow.getClickCounter(), 1);
        }

        else if (position == Position.RIGHT) {
            addOrSubtractFromGameBoardForRightArrows(arrow, arrow.getPreviousClickcounter(), -1);
            addOrSubtractFromGameBoardForRightArrows(arrow, arrow.getClickCounter(), 1);
        }

        System.out.println("currentGameBoard" + java.util.Arrays.deepToString(currentGameBoard));
        System.out.println("currentSolutionBoard" + java.util.Arrays.deepToString(currentSolutionBoard));
        checkIfGameEnd();
    }

    private void addOrSubtractFromGameBoardForUpperArrows(Arrow arrow, int clickCounter, int switcher) {
        if (clickCounter == 1) {
            int arrowCordX = arrow.getCordX() - 2;
            int arrowCordY = arrow.getCordY();
            for (int x = 0; x <= arrow.getCordX() - 2; x ++) {
                if (switcher == 1) {
                    currentGameBoard[arrowCordY][arrowCordX] ++;
                } else {
                    currentGameBoard[arrowCordY][arrowCordX] --;
                }

                arrowCordY ++;
                arrowCordX --;
            }
        }

        else if(clickCounter == 0) {
            for (int x = 0; x < 5; x ++) {
                if (switcher == 1) {
                    currentGameBoard[x][arrow.getCordX() - 1] ++;
                } else {
                    currentGameBoard[x][arrow.getCordX() - 1] --;
                }
            }
        }

        else if(clickCounter == 7) {
            int arrowCordX = arrow.getCordX();
            int arrowCordY = arrow.getCordY();
            for (int x = 5 - arrow.getCordX(); x > 0; x --) {
                if (switcher == 1) {
                    currentGameBoard[arrowCordY][arrowCordX] ++;
                } else {
                    currentGameBoard[arrowCordY][arrowCordX] --;
                }
                arrowCordY ++;
                arrowCordX ++;
            }
        }
    }

    private void addOrSubtractFromGameBoardForLeftArrows(Arrow arrow, int clickCounter, int switcher) {
        if (clickCounter == 5) {
            int arrowCordX = arrow.getCordX();
            int arrowCordY = arrow.getCordY() - 2;
            for (int x = 0; x < arrow.getCordY() - 1; x ++) {
                if (switcher == 1) {
                    currentGameBoard[arrowCordY][arrowCordX] ++;
                } else {
                    currentGameBoard[arrowCordY][arrowCordX] --;
                }
                arrowCordY --;
                arrowCordX ++;
            }
        } else if (clickCounter == 6) {
            for (int x = 0; x < 5; x ++) {
                if (switcher == 1) {
                    currentGameBoard[arrow.getCordY() - 1][x] ++;
                } else {
                    currentGameBoard[arrow.getCordY() - 1][x] --;
                }
            }
        } else if (clickCounter == 7) {
            int arrowCordX = arrow.getCordX();
            int arrowCordY = arrow.getCordY();
            for (int x = 5 - arrow.getCordY(); x > 0; x --) {
                if (switcher == 1) {
                    currentGameBoard[arrowCordY][arrowCordX] ++;
                } else {
                    currentGameBoard[arrowCordY][arrowCordX] --;
                }
                arrowCordY ++;
                arrowCordX ++;
            }
        }
    }

    private void addOrSubtractFromGameBoardForDownArrows(Arrow arrow, int clickCounter, int switcher) {
        if (clickCounter == 4) {
            int arrowCordX = arrow.getCordX() - 1;
            int arrowCordY = arrow.getCordY() - 2;
            for (int x = arrow.getCordY() - 2; x >= 0; x --) {
                if (switcher == 1) {
                    currentGameBoard[arrowCordY][arrowCordX] ++;
                } else {
                    currentGameBoard[arrowCordY][arrowCordX] --;
                }
                arrowCordY --;
            }
        } else if (clickCounter == 5) {
            int arrowCordX = arrow.getCordX();
            int arrowCordY = arrow.getCordY() - 2;
            for (int x = arrow.getCordX() - 1; x < arrow.getCordY() - 2; x ++) {
                if (switcher == 1) {
                    currentGameBoard[arrowCordY][arrowCordX] ++;
                } else {
                    currentGameBoard[arrowCordY][arrowCordX] --;
                }
                arrowCordX ++;
                arrowCordY --;
            }
        } else if (clickCounter == 3) {
            int arrowCordX = arrow.getCordX() - 2;
            int arrowCordY = arrow.getCordY() - 2;
            for (int x = arrow.getCordX() - 1; x > 0; x --) {
                if (switcher == 1) {
                    currentGameBoard[arrowCordY][arrowCordX] ++;
                } else {
                    currentGameBoard[arrowCordY][arrowCordX] --;
                }
                arrowCordX --;
                arrowCordY --;
            }
        }
    }

    private void addOrSubtractFromGameBoardForRightArrows(Arrow arrow, int clickCounter, int switcher) {
        if (clickCounter == 3) {
            int arrowCordX = arrow.getCordX() - 2;
            int arrowCordY = arrow.getCordY() - 2;
            for (int x = arrow.getCordY() - 2; x >= 0; x --) {
                if (switcher == 1) {
                    currentGameBoard[arrowCordY][arrowCordX] ++;
                } else {
                    currentGameBoard[arrowCordY][arrowCordX] --;
                }
                arrowCordY --;
                arrowCordX --;
            }
        } else if (clickCounter == 2) {
            for (int x = 0; x < 5; x ++) {
                if (switcher == 1) {
                    currentGameBoard[arrow.getCordY() - 1][x] ++;
                } else {
                    currentGameBoard[arrow.getCordY() - 1][x] --;
                }
            }
        } else if (clickCounter == 1) {
            int arrowCordX = arrow.getCordX() - 2;
            int arrowCordY = arrow.getCordY();
            for (int x = arrow.getCordY(); x < arrow.getCordX() - 1; x ++) {
                if (switcher == 1) {
                    currentGameBoard[arrowCordY][arrowCordX] ++;
                } else {
                    currentGameBoard[arrowCordY][arrowCordX] --;
                }
                arrowCordY ++;
                arrowCordX --;
            }
        }
    }

    public void resetCurrentGameBoard() {
        currentGameBoard = new int[][]{{4, 4, 4, 4, 4},
                {4, 4, 4, 4, 4},
                {4, 4, 4, 4, 4},
                {4, 4, 4, 4, 4},
                {4, 4, 4, 4, 4}};
    }

    public void setCurrentSolutionBoard(int[][] currentSolutionBoard) {
        this.currentSolutionBoard = currentSolutionBoard;
    }

    public int[][] getCurrentSolutionBoard() {
        return currentSolutionBoard;
    }
}


