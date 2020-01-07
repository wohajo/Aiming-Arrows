package controller;

import components.abstracts.Element;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ModelBoard;
import view.MainGUI;
import view.menuComponents.HelpPanel;

import java.io.File;

public class GameController {

    private MainGUI mainGUI;
    private HelpPanel helpPanel;
    private ModelBoard modelBoard;
    private Element[][] solutionBoard;
    private Element[][] gameBoard;
    // private FileManager fileManager;

    public GameController() {

        this.helpPanel = new HelpPanel();
        this.mainGUI = new MainGUI();
        this.modelBoard = new ModelBoard(7,7);

        mainGUI.getMenu().getStartGameButton().setOnAction(e -> {
            if(!mainGUI.getMenu().getStartGameButton().getIsClicked()) {
                mainGUI.changeMainView(mainGUI.getGameBoard().getGameGrid());
                mainGUI.getMenu().getStartGameButton().setId("menuButtonInactive");
            } else {
                mainGUI.changeMainView(mainGUI.getGameBoard().getGameGrid());
            }
        });

        mainGUI.getMenu().getHelpButton().setOnAction(e -> {
            if(!mainGUI.getMenu().getHelpButton().getIsClicked()) {
                mainGUI.getTopPane().changeLabelText("Rules");
                mainGUI.getMenu().getHelpButton().setText("Back");
                mainGUI.changeMainView(getHelpPanel());
                mainGUI.getMenu().getHelpButton().setIsClicked(true);
            } else {
                mainGUI.getMenu().getHelpButton().setText("Help");
                mainGUI.getTopPane().changeLabelToDefault();
                mainGUI.changeMainView(mainGUI.getGameBoard().getGameGrid());
                mainGUI.getMenu().getHelpButton().setIsClicked(false);
            }
        });

        mainGUI.getMenu().getExitGameButton().setOnAction(e -> {
            System.exit(0);
        });

        mainGUI.getMenu().getOpenFileButton().setOnAction(e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(stage);
            //Elements[][] newBoard = fileManager.prepareToLoad(selectedFile);
            //mainGUI.changeMainView(mainGUI.getGameBoard().setGameGrid(newBoard))

        });
    }

    public MainGUI getMainGUI() {
        return mainGUI;
    }

    public HelpPanel getHelpPanel() {
        return helpPanel;
    }

    public Element[][] getGameBoard() {
        return gameBoard;
    }

    public Element[][] getSolutionBoard() {
        return solutionBoard;
    }
}


