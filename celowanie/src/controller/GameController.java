package controller;

import javafx.scene.Parent;
import view.MainGUI;

public class GameController {

    MainGUI mainGUI;

    public GameController() {
        this.mainGUI = new MainGUI();
    }

    public MainGUI getMainGUI() {
        return mainGUI;
    }
}
