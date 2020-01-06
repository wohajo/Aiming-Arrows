package controller;

import components.abstracts.Element;
import interfaces.GameState;
import model.ModelBoard;
import view.menuComponents.GameGrid;
import view.MainGUI;
import view.menuComponents.HelpPanel;

public class GameController {

    private MainGUI mainGUI;
    private GameGrid viewBoard;
    private HelpPanel helpPanel;
    private Element[][] elements;
    GameState gameHelpState;
    GameState gameRunningState;
    GameState gameLoadState;

    public GameController() {

        this.helpPanel = new HelpPanel();
        this.mainGUI = new MainGUI();
        this.viewBoard = new GameGrid(7);
        mainGUI.getMenu().getExitGameButton().setOnAction(e -> {
            System.exit(0);
        });
        mainGUI.getMenu().getHelpButton().setOnAction(e -> {
            mainGUI.changeMainView(helpPanel);
        });

    }
    public MainGUI getMainGUI() {
        return mainGUI;
    }

    public Element[][] getElements() {
        return elements;
    }

    public GameGrid getViewBoard() {
        return viewBoard;
    }

    public GameState getGameHelpState() {
        return gameHelpState;
    }

    public GameState getGameLoadState() {
        return gameLoadState;
    }

    public GameState getGameRunningState() {
        return gameRunningState;
    }

    public HelpPanel getHelpPanel() {
        return helpPanel;
    }
}


