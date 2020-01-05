package controller;

import components.abstracts.Element;
import model.ModelBoard;
import view.menuComponents.GameGrid;
import view.MainGUI;

public class GameController {

    private MainGUI mainGUI;
    private GameGrid viewBoard;
    private ModelBoard modelBoard;
    private Element[][] elements;

    public GameController() {
        this.mainGUI = new MainGUI();
    }
    public MainGUI getMainGUI() {
        return mainGUI;
    }
    public ModelBoard getModelBoard() {
        return modelBoard;
    }
}
