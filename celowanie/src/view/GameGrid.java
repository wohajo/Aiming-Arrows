package view;

import components.abstracts.Element;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

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

    public GameGrid(Element[][] Elements, int dim) {

    }

    public GridPane getGameGrid() {
        return grid;
    }

    private void setupGameGrid(Element[][] Elements) {
        // for (int i = 0; i < E)
    }
}
