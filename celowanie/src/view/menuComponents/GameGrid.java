package view.menuComponents;

import components.abstracts.Element;
import components.gameObjects.Arrow;
import components.gameObjects.Block;
import components.gameObjects.Cell;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class GameGrid extends GridPane {

    private GridPane gameGrid;
    int[][] numbers = {{3, 3, 6, 2, 3}, {5, 4, 3, 2, 4}, {5, 2, 2, 0, 3}, {2, 2, 3, 0, 2}, {4, 3, 5, 3, 6}};

    public GameGrid() {
        this.gameGrid = new GridPane();
        for (int dimY = 0; dimY < 7; dimY++) {

            for (int dimX = 0; dimX < 7; dimX++) {

                if (dimY == 0 || dimY == 6 || dimX == 0 || dimX == 6) {

                    if ((dimY == 0 && dimX == 0) || (dimY == 0 && dimX == 6) || (dimY == 6 && dimX == 0) || (dimY == 6 && dimX == 6)) {
                        System.out.println("for dimX: " + dimX + " for dimY: " + dimY);
                        Block block = new Block(dimX, dimY);
                        System.out.println("blockX: " + block.getCordX() + " blockY: " + block.getCordY());
                        this.gameGrid.addRow(dimY, block);
                        block.setOnAction(e -> {
                            block.setText(block.getCordX() + " " + block.getCordY());
                            System.out.println("blockX: " + block.getCordX() + " blockY: " + block.getCordY());
                        });
                    } else {

                        if (dimX == 0) {

                            System.out.println("for dimX: " + dimX + " for dimY: " + dimY);
                            Arrow arrow = new Arrow(dimX, dimY);
                            System.out.println("arrowX: " + arrow.getCordX() + " arrowY: " + arrow.getCordY());
                            this.gameGrid.addRow(dimY, arrow);
                            arrow.setOnAction(e -> {
                                arrow.setText(arrow.getCordX() + " " + arrow.getCordY());
                                System.out.println("arrowX: " + arrow.getCordX() + " arrowY: " + arrow.getCordY());
                            });
                        } else if (dimY == 0) {

                            System.out.println("for dimX: " + dimX + " for dimY: " + dimY);
                            Arrow arrow = new Arrow(dimX, dimY);
                            System.out.println("arrowX: " + arrow.getCordX() + " arrowY: " + arrow.getCordY());
                            arrow.setStyle("-fx-background-image: url(/rsc/arrowRight.png)");
                            this.gameGrid.addRow(dimY, arrow);
                            arrow.setOnAction(e -> {
                                arrow.setText(arrow.getCordX() + " " + arrow.getCordY());
                                System.out.println("arrowX: " + arrow.getCordX() + " arrowY: " + arrow.getCordY());
                            });
                        } else if (dimX == 6) {

                            System.out.println("for dimX: " + dimX + " for dimY: " + dimY);
                            Arrow arrow = new Arrow(dimX, dimY);
                            System.out.println("arrowX: " + arrow.getCordX() + " arrowY: " + arrow.getCordY());
                            arrow.setStyle("-fx-background-image: url(/rsc/arrowUp.png)");
                            this.gameGrid.addRow(dimY, arrow);
                            arrow.setOnAction(e -> {
                                arrow.setText(arrow.getCordX() + " " + arrow.getCordY());
                                System.out.println("arrowX: " + arrow.getCordX() + " arrowY: " + arrow.getCordY());
                            });
                        } else {

                            System.out.println("for dimX: " + dimX + " for dimY: " + dimY);
                            Arrow arrow = new Arrow(dimX, dimY);
                            System.out.println("arrowX: " + arrow.getCordX() + " arrowY: " + arrow.getCordY());
                            arrow.setStyle("-fx-background-image: url(/rsc/arrowLeft.png)");
                            this.gameGrid.addRow(dimY, arrow);
                            arrow.setOnAction(e -> {
                                arrow.setText(arrow.getCordX() + " " + arrow.getCordY());
                                System.out.println("arrowX: " + arrow.getCordX() + " arrowY: " + arrow.getCordY());
                            });
                        }

                    }
                } else {

                    System.out.println("for dimX: " + dimX + " for dimY: " + dimY);
                    Cell cell = new Cell(dimX, dimY, (numbers[dimY - 1][dimX - 1]));
                    System.out.println("cellX: " + cell.getCordX() + " cellY: " + cell.getCordY());
                    cell.changeLabel(cell.getValue());
                    this.gameGrid.addRow(dimY, cell);
                    cell.setOnAction(e -> {
                        cell.setText(cell.getCordX() + " " + cell.getCordY());
                        System.out.println("cellX: " + cell.getCordX() + " cellY: " + cell.getCordY());
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

    private Element getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node element : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(element) == col && GridPane.getRowIndex(element) == row) {
                return (Element) element;
            }
        }
        return null;
    }
}
