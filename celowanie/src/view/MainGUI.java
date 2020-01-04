package view;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import view.menuComponents.GameGrid;
import view.menuComponents.Menu;
import view.menuComponents.TopPane;

public class MainGUI extends BorderPane {

    private TopPane topPane;
    private Menu rightPane;
    private GameGrid gameGrid;

    public MainGUI() {
        this.topPane = new TopPane();
        this.rightPane = new Menu();
        this.gameGrid = new GameGrid(7);

        this.gameGrid.setAlignment(Pos.CENTER);
        this.topPane.setAlignment(Pos.CENTER);
        this.rightPane.setAlignment(Pos.CENTER);

        this.setTop(topPane.getTopPane());
        this.setRight(rightPane.getMenu());
        this.setCenter(gameGrid.getGameGrid());
    }

    public void changeMainView(Pane pane) {
        this.setCenter(pane);
    }
}
