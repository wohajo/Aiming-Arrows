package controller;

import components.abstracts.Element;
import components.abstracts.Position;
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

        mainGUI.getMenu().getEditBoardButton().setOnAction(e -> {
            mainGUI.getGameBoard().setGameGridCells(modelBoard.getDefaultSolutionBoard());
        });
    }

    public MainGUI getMainGUI() {
        return mainGUI;
    }

    public HelpPanel getHelpPanel() {
        return helpPanel;
    }

    public Element getButtonFromBoard(int col, int row) {
        return mainGUI.getGameBoard().getElementFromGameGrid(mainGUI.getGameBoard().getGameGrid(), col, row);
    }

    public void setArrowsClicks() {
        // 4 * for
    }

    public void setArrowClick(int col, int row, int defaultClickCounter, Position position) {
        Element arrow = getButtonFromBoard(col, row);
        switch (position) {
            case UP:
                if (arrow.getCordX() == 1) {

                } else if () {

                } else {

                }

            case DOWN:
                if (arrow.getCordX() == 1) {

                } else if () {

                } else {

                }

            case LEFT:
                if (arrow.getCordX() == 1) {

                } else if () {

                } else {

                }

            case RIGHT:
                if (arrow.getCordX() == 1) {

                } else if () {

                } else {

                }
        }
           getButtonFromBoard(col, row).setOnAction(e -> {
                if(getButtonFromBoard(col, row).getClickCounter() == 0) {
                    getButtonFromBoard(col, row).setStyle("-fx-background-image: url(/rsc/7arrowDownRight.png)");
                    getButtonFromBoard(col, row).setClickCounter(7);
                } else {
                    getButtonFromBoard(col, row).setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
                    getButtonFromBoard(col, row).setClickCounter(0);
                }
            });
    }
}


