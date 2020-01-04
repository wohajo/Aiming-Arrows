package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.BorderPane;

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
}
