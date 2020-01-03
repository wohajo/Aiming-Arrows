package controller;

import javafx.scene.Parent;
import model.ModelBoard;
import view.MainGUI;
import view.ViewBoard;

public class GameController {

    private MainGUI mainGUI;
    private ViewBoard viewBoard;
    private ModelBoard modelBoard;

    public GameController() {
        this.mainGUI = new MainGUI();
    }

    public MainGUI getMainGUI() {
        return mainGUI;
    }
    public ViewBoard getViewBoard() {
        return viewBoard;
    }
    public ModelBoard getModelBoard() {
        return modelBoard;
    }
}
