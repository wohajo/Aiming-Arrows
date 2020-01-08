package controller;

import components.abstracts.Element;
import components.abstracts.Position;
import components.gameObjects.Arrow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ModelBoard;
import view.MainGUI;
import view.buttons.MenuButton;
import view.menuComponents.EndGamePanel;
import view.menuComponents.HelpPanel;
import java.io.File;

public class GameController {

    private MainGUI mainGUI;
    private HelpPanel helpPanel;
    private EndGamePanel endGamePanel;
    private ModelBoard modelBoard;
    // private FileManager fileManager;

    public GameController() {

        this.helpPanel = new HelpPanel();
        this.endGamePanel = new EndGamePanel();
        this.mainGUI = new MainGUI();
        this.modelBoard = new ModelBoard(7,7);

        setArrowsClicks();

        this.getStartButton().setOnAction(e -> {
            if(!getStartButton().getIsClicked()) {
                mainGUI.getGameBoard().setGameGridCellsValues(modelBoard.getDefaultSolutionBoard());
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

        this.getEditBoardButton().setOnAction(e -> {
            if(!getEditBoardButton().getIsClicked()) {
                mainGUI.getTopPane().changeLabelText("Board editor");
                getEditBoardButton().setText("Back");
                for (int x = 1; x < 6; x ++) {
                    for (int y = 1; y < 6; y ++) {
                        Element cell = getButtonFromBoard(x ,y);
                        cell.setId("cellElementEditable");
                        cell.setOnAction(f -> {
                            cell.valueInc();
                            cell.setText(String.valueOf(cell.getValue()));
                        });
                    }
                }
                getEditBoardButton().setIsClicked(true);
            } else {
                for (int x = 1; x < 6; x ++) {
                    for (int y = 1; y < 6; y ++) {
                        Element cell = getButtonFromBoard(x ,y);
                        cell.setId("cellElement");
                        cell.setOnAction(g -> {

                        });
                    }
                }
                mainGUI.getTopPane().changeLabelText("Aiming Arrows");
                getEditBoardButton().setText("Edit");
                mainGUI.getGameBoard().setArrowsToDefault();
                getEditBoardButton().setIsClicked(false);
            }
        });
    }

    public MenuButton getStartButton() {
        return this.mainGUI.getMenu().getStartGameButton();
    }

    public MenuButton getEditBoardButton() {
        return this.mainGUI.getMenu().getEditBoardButton();
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
        for(int i = 1; i < 6; i++)
            setArrowClick(i, 0, Position.UP);
        for(int i = 1; i < 6; i++)
            setArrowClick(i, 6, Position.DOWN);
        for(int i = 1; i < 6; i++)
            setArrowClick(0, i, Position.LEFT);
        for(int i = 1; i < 6; i++)
            setArrowClick(6, i, Position.RIGHT);
    }

    public void setArrowClick(int col, int row, Position position) {
        Arrow arrow = (Arrow) this.getButtonFromBoard(col, row);
        if (position == Position.UP) {
            if (arrow.getCordX() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 0) {
                        arrow.setArrowDownRight(arrow);
                    } else {
                        arrow.setArrowDown(arrow);
                    }
                });
            } else if (arrow.getCordX() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 0) {
                        arrow.setArrowDownLeft(arrow);
                    } else if (arrow.getClickCounter() == 1) {
                        arrow.setArrowDown(arrow);
                    }
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 0) {
                        arrow.setArrowDownLeft(arrow);
                    } else if (arrow.getClickCounter() == 1) {
                        arrow.setArrowDownRight(arrow);
                    } else {
                        arrow.setArrowDown(arrow);
                    }
                });
            }
        }

        if (position == Position.DOWN) {
            if (arrow.getCordX() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 4) {
                        arrow.setArrowUpRight(arrow);
                    } else {
                        arrow.setArrowUp(arrow);
                    }
                });
            } else if (arrow.getCordX() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 3) {
                        arrow.setArrowUp(arrow);
                    } else {
                        arrow.setArrowUpLeft(arrow);
                    }
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 4) {
                        arrow.setArrowUpRight(arrow);
                    } else if (arrow.getClickCounter() == 5) {
                        arrow.setArrowUpLeft(arrow);
                    } else {
                        arrow.setArrowUp(arrow);
                    }
                });
            }
        }

        if (position == Position.LEFT) {
            if (arrow.getCordY() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 7) {
                        arrow.setArrowRight(arrow);
                    } else {
                        arrow.setArrowDownRight(arrow);
                    }
                });
            } else if (arrow.getCordY() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 6) {
                        arrow.setArrowUpRight(arrow);
                    } else {
                        arrow.setArrowRight(arrow);
                    }
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 6) {
                        arrow.setArrowDownRight(arrow);
                    } else if (arrow.getClickCounter() == 7) {
                        arrow.setArrowUpRight(arrow);
                    } else {
                        arrow.setArrowRight(arrow);
                    }
                });
            }
        }

        if (position == Position.RIGHT) {
            if (arrow.getCordY() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 1) {
                        arrow.setArrowLeft(arrow);
                    } else {
                        arrow.setArrowDownLeft(arrow);
                    }
                });
            } else if (arrow.getCordY() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 3) {
                        arrow.setArrowLeft(arrow);
                    } else {
                        arrow.setArrowUpLeft(arrow);
                    }
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 2) {
                        arrow.setArrowUpLeft(arrow);
                    } else if (arrow.getClickCounter() == 3) {
                        arrow.setArrowDownLeft(arrow);
                    } else {
                        arrow.setArrowLeft(arrow);
                    }
                });
            }
        }
    }
}