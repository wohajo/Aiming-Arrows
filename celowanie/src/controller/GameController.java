package controller;

import components.abstracts.Element;
import components.abstracts.Position;
import components.gameObjects.Arrow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ModelBoard;
import view.MainGUI;
import view.buttons.MenuButton;

import java.io.File;
import java.util.Arrays;

public class GameController {

    private MainGUI mainGUI;
    private ModelBoard modelBoard;
    // private FileManager fileManager;

    public GameController() {

        this.mainGUI = new MainGUI();
        this.modelBoard = new ModelBoard(7,7);

        setArrowsClicks();

        this.getStartButton().setOnAction(e -> {
            if(!getStartButton().getIsClicked()) {
                mainGUI.getGameBoard().setGameGridCellsValues(modelBoard.getStartGameBoard());
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
                mainGUI.changeMainView(mainGUI.getHelpPanel());
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
                        int finalX = x;
                        int finalY = y;
                        cell.setOnAction(f -> {
                            cell.valueInc();
                            cell.setText(String.valueOf(cell.getValue()));
                            // save changes to current board
                            this.modelBoard.getCurrentSolutionBoard()[finalX - 1][finalY - 1] = cell.getValue();
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
                modelBoard.resetCurrentGameBoard();
                System.out.println(Arrays.deepToString(modelBoard.getCurrentGameBoard()));
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
                        arrow.setArrowDownRight(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowDown(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            } else if (arrow.getCordX() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 0) {
                        arrow.setArrowDownLeft(arrow, arrow.getClickCounter());
                    } else if (arrow.getClickCounter() == 1) {
                        arrow.setArrowDown(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 0) {
                        arrow.setArrowDownLeft(arrow, arrow.getClickCounter());
                    } else if (arrow.getClickCounter() == 1) {
                        arrow.setArrowDownRight(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowDown(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            }
        }

        if (position == Position.DOWN) {
            if (arrow.getCordX() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 4) {
                        arrow.setArrowUpRight(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowUp(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            } else if (arrow.getCordX() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 3) {
                        arrow.setArrowUp(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowUpLeft(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 4) {
                        arrow.setArrowUpRight(arrow, arrow.getClickCounter());
                    } else if (arrow.getClickCounter() == 5) {
                        arrow.setArrowUpLeft(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowUp(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            }
        }

        if (position == Position.LEFT) {
            if (arrow.getCordY() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 7) {
                        arrow.setArrowRight(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowDownRight(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            } else if (arrow.getCordY() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 6) {
                        arrow.setArrowUpRight(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowRight(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 6) {
                        arrow.setArrowDownRight(arrow, arrow.getClickCounter());
                    } else if (arrow.getClickCounter() == 7) {
                        arrow.setArrowUpRight(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowRight(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            }
        }

        if (position == Position.RIGHT) {
            if (arrow.getCordY() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 1) {
                        arrow.setArrowLeft(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowDownLeft(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            } else if (arrow.getCordY() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 3) {
                        arrow.setArrowLeft(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowUpLeft(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 2) {
                        arrow.setArrowUpLeft(arrow, arrow.getClickCounter());
                    } else if (arrow.getClickCounter() == 3) {
                        arrow.setArrowDownLeft(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowLeft(arrow, arrow.getClickCounter());
                    }
                    this.checkIfEnd();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                });
            }
        }
    }

    public void checkIfEnd() {
        if (this.modelBoard.checkIfGameEnd()) {
            System.out.println(this.modelBoard.checkIfGameEnd());
            this.mainGUI.changeMainView(mainGUI.getEndGamePanel());
        }
    }
}