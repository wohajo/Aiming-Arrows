package view.menuComponents;

import components.abstracts.Element;
import javafx.scene.layout.GridPane;
import view.buttons.GameButton;

public class GameGrid extends GridPane {

    private GridPane grid;

    public GameGrid(int dim) {
        this.grid = new GridPane();
        for (int i = 0; i < dim; i++)
            for (int j = 0; j < dim; j++) {
                if (i == 0 || i == dim - 1 || j == 0 || j == dim - 1) {
                    if ( (i == 0 && j == 0) || (i == 0 && j == dim - 1) || (i == dim - 1 && j == 0) || (i == dim - 1 && j == dim - 1)) {
                        GameButton button = new GameButton("block", "blockElement");
                        this.grid.addRow(j, button);
                    } else {
                        GameButton button = new GameButton("arrow", "arrowElement");
                        this.grid.addRow(j, button);
                    }
                } else {
                    GameButton button = new GameButton("cell", "cellElement");
                    this.grid.addRow(j, button);
                }
            };
    }

    public GameGrid(int dim, Element[][] Elements) {
        this.grid = new GridPane();
        for (int i = 0; i < dim; i++)
            for (int j = 0; j < dim; j++) {
                if (i == 0 || i == dim - 1 || j == 0 || j == dim - 1) {
                    if ( (i == 0 && j == 0) || (i == 0 && j == dim - 1) || (i == dim - 1 && j == 0) || (i == dim - 1 && j == dim - 1)) {
                        this.grid.addRow(j, Elements[i][j]);
                    } else {
                        this.grid.addRow(j, Elements[i][j]);
                    }
                } else {
                    this.grid.addRow(j, Elements[i][j]);
                }
            };
    }

    public GridPane getGameGrid() {
        return grid;
    }

    private void setupGameGrid(Element[][]  Elements) {
        // for (int i = 0; i < E)
    }
}
