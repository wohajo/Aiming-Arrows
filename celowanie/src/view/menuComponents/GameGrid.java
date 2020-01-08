package view.menuComponents;

import components.abstracts.Element;
import components.gameObjects.Arrow;
import components.gameObjects.Block;
import components.gameObjects.Cell;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class GameGrid extends GridPane {

    private GridPane gameGrid;
    int[][] startGameBoard = {
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4},
            {4, 4, 4, 4, 4}};

    public GameGrid() {
        this.gameGrid = new GridPane();
        for (int dimY = 0; dimY < 7; dimY++) {

            for (int dimX = 0; dimX < 7; dimX++) {

                if (dimY == 0 || dimY == 6 || dimX == 0 || dimX == 6) {

                    if ((dimY == 0 && dimX == 0) || (dimY == 0 && dimX == 6) || (dimY == 6 && dimX == 0) || (dimY == 6 && dimX == 6)) {
                        Block block = new Block(dimX, dimY);
                        this.gameGrid.addRow(dimY, block);

                        block.setOnAction(e -> {
                            System.out.println("X: " +  block.getCordX() + " Y: " +  block.getCordY());
                        });

                    } else {

                        if (dimX == 0) {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setClickCounter(6);
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        } else if (dimY == 0) {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setClickCounter(0);
                            arrow.setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        } else if (dimX == 6) {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setClickCounter(2);
                            arrow.setStyle("-fx-background-image: url(/rsc/2arrowLeft.png)");
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        } else {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setClickCounter(4);
                            arrow.setStyle("-fx-background-image: url(/rsc/4arrowUp.png)");
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        }


                    }
                } else {

                    Cell cell = new Cell(dimX, dimY, (startGameBoard[dimY - 1][dimX - 1]));
                    cell.changeLabel(cell.getValue());
                    this.gameGrid.addRow(dimY, cell);

                    cell.setOnAction(e -> {
                        System.out.println("X: " +  cell.getCordX() + " Y: " +  cell.getCordY());
                    });

                }
            }
        }
    }

    public GameGrid(int[][] gameBoard) {
        this.gameGrid = new GridPane();
        for (int dimY = 0; dimY < 7; dimY++) {

            for (int dimX = 0; dimX < 7; dimX++) {

                if (dimY == 0 || dimY == 6 || dimX == 0 || dimX == 6) {

                    if ((dimY == 0 && dimX == 0) || (dimY == 0 && dimX == 6) || (dimY == 6 && dimX == 0) || (dimY == 6 && dimX == 6)) {
                        Block block = new Block(dimX, dimY);
                        this.gameGrid.addRow(dimY, block);

                        block.setOnAction(e -> {
                            System.out.println("X: " +  block.getCordX() + " Y: " +  block.getCordY());
                        });

                    } else {

                        if (dimX == 0) {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setClickCounter(6);
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        } else if (dimY == 0) {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setClickCounter(0);
                            arrow.setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        } else if (dimX == 6) {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setClickCounter(2);
                            arrow.setStyle("-fx-background-image: url(/rsc/2arrowLeft.png)");
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        } else {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setClickCounter(4);
                            arrow.setStyle("-fx-background-image: url(/rsc/4arrowUp.png)");
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        }


                    }
                } else {

                    Cell cell = new Cell(dimX, dimY, (gameBoard[dimY - 1][dimX - 1]));
                    cell.changeLabel(cell.getValue());
                    this.gameGrid.addRow(dimY, cell);

                    cell.setOnAction(e -> {
                        System.out.println("X: " +  cell.getCordX() + " Y: " +  cell.getCordY());
                    });

                }
            }
        }
    }

    public GridPane getGameGrid() {
        return gameGrid;
    }

    public Element getElementFromGameGrid(GridPane gridPane, int col, int row) {
        for (Node element : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(element) == col && GridPane.getRowIndex(element) == row) {
                return (Element) element;
            }
        }
        return null;
    }

    public void setArrowsToDefault() {
        for (int p = 1; p < 6; p ++) {
            Arrow arrow = (Arrow) this.getElementFromGameGrid(gameGrid, p, 0);
            arrow.setArrowDown(arrow);
        }
        for (int q = 1; q < 6; q ++) {
            Arrow arrow = (Arrow) this.getElementFromGameGrid(gameGrid, q, 6);
            arrow.setArrowUp(arrow);
        }
        for (int r = 1; r < 6; r ++) {
            Arrow arrow = (Arrow) this.getElementFromGameGrid(gameGrid, 0, r);
            arrow.setArrowRight(arrow);

        }
        for (int s = 1; s < 6; s ++) {
            Arrow arrow = (Arrow) this.getElementFromGameGrid(gameGrid, 6, s);
            arrow.setArrowLeft(arrow);
        }
    }

    public void setGameGridCellsValues(int[][] gameCellsLabels) {
        for(int x = 1; x < 6; x ++) {
            for(int y = 1; y < 6; y ++) {
                this.getElementFromGameGrid(gameGrid, x, y).setText(String.valueOf(gameCellsLabels[x - 1][y - 1]));
                this.getElementFromGameGrid(gameGrid, x, y).setValue(gameCellsLabels[x - 1][y - 1]);
            }
        }
    }

    public int[][] getGameGridCellsValues() {
        int[][] cellsValues = new int[5][5];
        for (int x = 1; x < 6; x ++) {
            for (int y = 1; y < 6; y++) {
                cellsValues[x - 1][y - 1] = this.getElementFromGameGrid(gameGrid, x, y).getValue();
            }
        }
        return cellsValues;
    }
}
