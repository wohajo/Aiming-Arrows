package controller;

import model.ModelBoard;
import view.GameGrid;
import view.MainGUI;

public class GameController {

    private MainGUI mainGUI;
    private GameGrid viewBoard;
    private ModelBoard modelBoard;

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
