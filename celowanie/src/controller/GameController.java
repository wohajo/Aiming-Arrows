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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameController {

    private int historianListIterator;
    private boolean isFirstLaunched;
    private List<Historian> historianList;
    private MainGUI mainGUI;
    private ModelBoard modelBoard;
    private FileManager fileManager;

    public GameController() {

        this.historianListIterator = 0;
        this.historianList = new ArrayList<>();
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
                getHelpButton().setText("Help");
                mainGUI.getTopPane().changeLabelToDefault();
                getHelpButton().setIsClicked(false);
            } else {
                mainGUI.changeMainView(mainGUI.getGameBoard().getGameGrid());
            }
        });

        mainGUI.getMenu().getOpenFileButton().setOnAction(e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/.aassaves"));

            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("Aiming Arrows save files (*.aas)", "*.aas");
            fileChooser.getExtensionFilters().add(extFilter);

            File selectedFile = fileChooser.showOpenDialog(stage);
            String filePath = selectedFile.getAbsolutePath();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(new File(filePath));
            } catch (NullPointerException ex) {
                System.out.println("File not selected error");
            }
            catch (FileNotFoundException ex) {
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
            this.setHistorianList(savedFile.getHistorianListFromSave());
            this.historianListIterator = savedFile.getHistorianListFromSave().size();
        });

        mainGUI.getMenu().getSaveFileButton().setOnAction(e -> {
            fileManager.saveFile(modelBoard, mainGUI.getGameBoard().getArrowsClickCounters(), historianList);
            mainGUI.getTopPane().changeLabelText("Saved file!");
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
                getEditBoardButton().setIsClicked(false);
            }
        });

        getForwardButton().setOnAction(e -> {
            historianListIterator ++;
            if (historianList.size() == 0) {
            } else if (historianListIterator > historianList.size() - 1) {
                historianListIterator = historianList.size() - 1;
            } else {
                getForwardButton().setId("menuButton");
                this.modelBoard.setCurrentGameBoard(this.historianList.get(historianListIterator).getCurrentGameBoard());
                this.mainGUI.getGameBoard().setArrowsClickCounters(this.historianList.get(historianListIterator).getArrowClickCounters());

                setArrowsAfterChange();
            }
        });

        mainGUI.getMenu().getBackButton().setOnAction(e -> {
            historianListIterator --;

            if (historianList.size() == 0) {
            } else if (historianListIterator < 0) {
                historianListIterator = 0;
                setArrowsAfterChange();
            } else {
                mainGUI.getMenu().getBackButton().setId("menuButton");
                this.modelBoard.setCurrentGameBoard(this.historianList.get(historianListIterator).getCurrentGameBoard());
                this.mainGUI.getGameBoard().setArrowsClickCounters(this.historianList.get(historianListIterator).getArrowClickCounters());

                setArrowsAfterChange();
            }
        });

        getHelpButton().setOnAction(e -> {
            if (isFirstLaunched) {
                mainGUI.getGameBoard().setGameGridCellsValues(modelBoard.getDefaultSolutionBoard());
                modelBoard.setCurrentSolutionBoard(modelBoard.getDefaultSolutionBoard());
                this.getStartButton().setText("Board");
                isFirstLaunched = false;
            }
            if(!getHelpButton().getIsClicked()) {
                mainGUI.getTopPane().changeLabelText("Rules");
                getHelpButton().setText("Back");
                mainGUI.changeMainView(mainGUI.getHelpPanel());
                getHelpButton().setIsClicked(true);
            } else {
                getHelpButton().setText("Help");
                mainGUI.getTopPane().changeLabelToDefault();
                mainGUI.changeMainView(mainGUI.getGameBoard().getGameGrid());
                getHelpButton().setIsClicked(false);
            }
        });

        mainGUI.getMenu().getExitGameButton().setOnAction(e -> {
            System.exit(0);
        });
    }

    public void setArrowsAfterChange() {
        for (int p = 1; p < 6; p ++) {
            Arrow arrow = (Arrow) getButtonFromBoard(0, p);
            arrow.setArrowsAccordingToClickCounter(arrow, arrow.getClickCounter());
        }
        for (int q = 1; q < 6; q ++) {
            Arrow arrow = (Arrow) getButtonFromBoard(q, 6);
            arrow.setArrowsAccordingToClickCounter(arrow, arrow.getClickCounter());
        }
        for (int r = 1; r < 6; r ++) {
            Arrow arrow = (Arrow) getButtonFromBoard(0, r);
            arrow.setArrowsAccordingToClickCounter(arrow, arrow.getClickCounter());

        }
        for (int s = 1; s < 6; s ++) {
            Arrow arrow = (Arrow) getButtonFromBoard(6, s);
            arrow.setArrowsAccordingToClickCounter(arrow, arrow.getClickCounter());
        }
    }

    public MenuButton getHelpButton() {
        return mainGUI.getMenu().getHelpButton();
    }

    public MenuButton getForwardButton() {
        return mainGUI.getMenu().getForwardButton();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
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
                    addMoveHistory();
                    modelBoard.modifyGameBoardAfterMove(arrow, position);
                    this.checkIfEnd();
                });
            }
        }
    }

    public void checkIfEnd() {
        if (this.modelBoard.checkIfGameEnd()) {
            this.mainGUI.changeMainView(mainGUI.getEndGamePanel());
        }
    }

    public void addMoveHistory() {
        this.historianList.add(new Historian(this.mainGUI.getGameBoard().getArrowsClickCounters(), this.modelBoard.getCurrentGameBoard()));
        try {
            historianList.subList(historianListIterator + 1, historianList.size()).clear();
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        this.historianListIterator = this.historianList.size();
    }

    public void setHistorianList(List<Historian> historianList) {
        this.historianList = historianList;
    }
}