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
    int[][] startGameBoard = {{4, 4, 4, 4, 4}, {4, 4, 4, 4, 4}, {4, 4, 4, 4, 4}, {4, 4, 4, 4, 4}, {4, 4, 4, 4, 4}};

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
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        } else if (dimY == 0) {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        } else if (dimX == 6) {

                            Arrow arrow = new Arrow(dimX, dimY);
                            arrow.setStyle("-fx-background-image: url(/rsc/2arrowLeft.png)");
                            this.gameGrid.addRow(dimY, arrow);

                            arrow.setOnAction(e -> {
                                System.out.println("X: " +  arrow.getCordX() + " Y: " +  arrow.getCordY());
                            });

                        } else {

                            Arrow arrow = new Arrow(dimX, dimY);
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

    public GameGrid(int dim, Element[][] elements) {
        this.gameGrid = new GridPane();
        for (int x = 0; x < dim; x++)
            for (int y = 0; y < dim; y++) {
                if (x == 0 || x == dim - 1 || y == 0 || y == dim - 1) {
                    if ( (x == 0 && y == 0) || (x == 0 && y == dim - 1) || (x == dim - 1 && y == 0) || (x == dim - 1 && y == dim - 1)) {
                        this.gameGrid.addRow(y, elements[x][y]);
                    } else {
                        if (y == 0) {
                            this.gameGrid.addRow(y, elements[x][y]);
                        } else if (x == 0) {
                            this.gameGrid.addRow(y, elements[x][y]);
                        } else if ( y == 6) {
                            this.gameGrid.addRow(y, elements[x][y]);
                        } else {
                            this.gameGrid.addRow(y, elements[x][y]);
                        }

                    }
                } else {
                    this.gameGrid.addRow(y, elements[x][y]);
                }
            };
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

    public void setGameGridCells(int[][] gameCellsLabels) {
        for(int x = 1; x < 6; x ++) {
            for(int y = 1; y < 6; y ++) {
                this.getElementFromGameGrid(gameGrid, x, y).setText(String.valueOf(gameCellsLabels[x - 1][y - 1]));
            }
        }
    }
}
