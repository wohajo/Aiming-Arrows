package controller;

import components.abstracts.Element;
import components.abstracts.Position;
import components.gameObjects.Arrow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ModelBoard;
import view.MainGUI;
import view.buttons.MenuButton;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class GameController {

    private boolean isFirstLaunched;
    private MainGUI mainGUI;
    private ModelBoard modelBoard;
    private FileManager fileManager;

    public GameController() {

        this.isFirstLaunched = true;
        this.fileManager = new FileManager();
        this.mainGUI = new MainGUI();
        this.modelBoard = new ModelBoard();

        setArrowsClicks();

        this.getStartButton().setOnAction(e -> {
            if(!getStartButton().getIsClicked()) {
                if (isFirstLaunched) {
                    mainGUI.getGameBoard().setGameGridCellsValues(modelBoard.getDefaultSolutionBoard());
                    modelBoard.setCurrentSolutionBoard(modelBoard.getDefaultSolutionBoard());
                    isFirstLaunched = false;
                }
                mainGUI.changeMainView(mainGUI.getGameBoard().getGameGrid());
                mainGUI.getMenu().getStartGameButton().setText("Board");
                mainGUI.getMenu().getHelpButton().setText("Help");
                mainGUI.getTopPane().changeLabelToDefault();
                mainGUI.getMenu().getHelpButton().setIsClicked(false);
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

        mainGUI.getMenu().getSaveFileButton().setOnAction(e -> {
            fileManager.saveFile(modelBoard, mainGUI.getGameBoard().getArrowsClickCounters());
            mainGUI.getTopPane().changeLabelText("Saved file!");
        });

        mainGUI.getMenu().getOpenFileButton().setOnAction(e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/.aassaves"));
            File selectedFile = fileChooser.showOpenDialog(stage);
            String filePath = selectedFile.getAbsolutePath();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(new File(filePath));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            ObjectInputStream oi = null;
            try {
                oi = new ObjectInputStream(fileInputStream);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            FileManager.GameFile savedFile = null;
            try {
                savedFile = (FileManager.GameFile) oi.readObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            this.modelBoard.setCurrentGameBoard(savedFile.getModelBoardFromSave().getCurrentGameBoard());
            this.modelBoard.setCurrentSolutionBoard(savedFile.getModelBoardFromSave().getCurrentSolutionBoard());
            this.mainGUI.getGameBoard().setGameGridCellsValues(savedFile.getModelBoardFromSave().getCurrentSolutionBoard());
            this.mainGUI.getGameBoard().setArrowsClickCounters(savedFile.getArrowsValuesFromSave());
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
                            this.modelBoard.setCurrentSolutionBoardCell(finalY - 1, finalX - 1, cell.getValue());
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
                mainGUI.getGameBoard().resetArrows();
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
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
                });
            } else if (arrow.getCordX() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 0) {
                        arrow.setArrowDownLeft(arrow, arrow.getClickCounter());
                    } else if (arrow.getClickCounter() == 1) {
                        arrow.setArrowDown(arrow, arrow.getClickCounter());
                    }
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
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
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
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
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
                });
            } else if (arrow.getCordX() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 3) {
                        arrow.setArrowUp(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowUpLeft(arrow, arrow.getClickCounter());
                    }
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
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
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
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
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
                });
            } else if (arrow.getCordY() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 6) {
                        arrow.setArrowUpRight(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowRight(arrow, arrow.getClickCounter());
                    }
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
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
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
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
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
                });
            } else if (arrow.getCordY() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 3) {
                        arrow.setArrowLeft(arrow, arrow.getClickCounter());
                    } else {
                        arrow.setArrowUpLeft(arrow, arrow.getClickCounter());
                    }
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
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
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
                });
            }
        }
    }

    public void loadNewGameBoardWithDefaultArrows(int[][] numbers) {
        this.modelBoard.setCurrentSolutionBoard(numbers);
        this.mainGUI.getGameBoard().setGameGridCellsValues(numbers);
        this.modelBoard.resetCurrentGameBoard();
        this.mainGUI.getGameBoard().resetArrows();
    }

    public void checkIfEnd() {
        if (this.modelBoard.checkIfGameEnd()) {
            System.out.println(this.modelBoard.checkIfGameEnd());
            this.mainGUI.changeMainView(mainGUI.getEndGamePanel());
        } else
            System.out.println(this.modelBoard.checkIfGameEnd());
    }

    public ModelBoard getModelBoard() {
        return this.modelBoard;
    }
}