package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import view.menuComponents.GameGrid;
import view.menuComponents.HelpPanel;
import view.menuComponents.Menu;
import view.menuComponents.TopPane;

public class MainGUI extends BorderPane {

    private TopPane topPane;
    private Menu menu;
    private GameGrid gameBoard;

    public MainGUI() {
        this.topPane = new TopPane();
        this.menu = new Menu();
        this.gameBoard = new GameGrid(7);

        this.gameBoard.setAlignment(Pos.CENTER);
        this.topPane.setAlignment(Pos.CENTER);
        this.menu.setAlignment(Pos.CENTER);

        this.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));
        this.setTop(topPane.getTopPane());
        this.setRight(menu.getVboxMenu());
        this.setCenter(gameBoard.getGameGrid());
    }

    public void changeMainView(Pane pane) {
        this.setCenter(pane);
    }

    public Menu getMenu() {
        return menu;
    }

    public TopPane getTopPane() {
        return topPane;
    }

    public GameGrid getGameBoard() {
        return gameBoard;
    }

    public void setGameGrid(GameGrid gameGrid) {
        this.gameBoard = gameGrid;
    }
}
