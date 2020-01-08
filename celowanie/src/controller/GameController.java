package controller;

import components.abstracts.Element;
import components.abstracts.Position;
import javafx.geometry.Pos;
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

        setArrowsClicks();

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
        Element arrow = this.getButtonFromBoard(col, row);
        if (position == Position.UP) {
            if (arrow.getCordX() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 0) {
                        arrow.setStyle("-fx-background-image: url(/rsc/7arrowDownRight.png)");
                        arrow.setClickCounter(7);
                    } else {
                        arrow.setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
                        arrow.setClickCounter(0);
                    }
                });
            } else if (arrow.getCordX() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 0) {
                        arrow.setStyle("-fx-background-image: url(/rsc/1arrowDownLeft.png)");
                        arrow.setClickCounter(1);
                    } else if (arrow.getClickCounter() == 1) {
                        arrow.setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
                        arrow.setClickCounter(0);
                    }
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 0) {
                        arrow.setStyle("-fx-background-image: url(/rsc/1arrowDownLeft.png)");
                        arrow.setClickCounter(1);
                    } else if (arrow.getClickCounter() == 1) {
                        arrow.setStyle("-fx-background-image: url(/rsc/7arrowDownRight.png)");
                        arrow.setClickCounter(7);
                    } else {
                        arrow.setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
                        arrow.setClickCounter(0);
                    }
                });
            }
        }

        if (position == Position.DOWN) {
            if (arrow.getCordX() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 4) {
                        arrow.setStyle("-fx-background-image: url(/rsc/5arrowUpRight.png)");
                        arrow.setClickCounter(5);
                    } else {
                        arrow.setStyle("-fx-background-image: url(/rsc/4arrowUp.png)");
                        arrow.setClickCounter(4);
                    }
                });
            } else if (arrow.getCordX() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 4) {
                        arrow.setStyle("-fx-background-image: url(/rsc/4arrowUp.png)");
                        arrow.setClickCounter(3);
                    } else if (arrow.getClickCounter() == 3) {
                        arrow.setStyle("-fx-background-image: url(/rsc/3arrowUpLeft.png)");
                        arrow.setClickCounter(4);
                    }
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 4) {
                        arrow.setStyle("-fx-background-image: url(/rsc/5arrowUpRight.png)");
                        arrow.setClickCounter(5);
                    } else if (arrow.getClickCounter() == 5) {
                        arrow.setStyle("-fx-background-image: url(/rsc/3arrowUpLeft.png)");
                        arrow.setClickCounter(3);
                    } else {
                        arrow.setStyle("-fx-background-image: url(/rsc/4arrowUp.png)");
                        arrow.setClickCounter(4);
                    }
                });
            }
        }

        if (position == Position.LEFT) {
            if (arrow.getCordY() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 6) {
                        arrow.setStyle("-fx-background-image: url(/rsc/6arrowRight.png)");
                        arrow.setClickCounter(7);
                    } else {
                        arrow.setStyle("-fx-background-image: url(/rsc/7arrowDownRight.png)");
                        arrow.setClickCounter(6);
                    }
                });
            } else if (arrow.getCordY() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 6) {
                        arrow.setStyle("-fx-background-image: url(/rsc/6arrowRight.png)");
                        arrow.setClickCounter(5);
                    } else if (arrow.getClickCounter() == 5) {
                        arrow.setStyle("-fx-background-image: url(/rsc/5arrowUpRight.png)");
                        arrow.setClickCounter(6);
                    }
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 6) {
                        arrow.setStyle("-fx-background-image: url(/rsc/6arrowRight.png)");
                        arrow.setClickCounter(7);
                    } else if (arrow.getClickCounter() == 7) {
                        arrow.setStyle("-fx-background-image: url(/rsc/7arrowDownRight.png)");
                        arrow.setClickCounter(5);
                    } else {
                        arrow.setStyle("-fx-background-image: url(/rsc/5arrowUpRight.png)");
                        arrow.setClickCounter(6);
                    }
                });
            }
        }

        if (position == Position.RIGHT) {
            if (arrow.getCordY() == 1) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 2) {
                        arrow.setStyle("-fx-background-image: url(/rsc/2arrowLeft.png)");
                        arrow.setClickCounter(1);
                    } else {
                        arrow.setStyle("-fx-background-image: url(/rsc/1arrowDownLeft.png)");
                        arrow.setClickCounter(2);
                    }
                });
            } else if (arrow.getCordY() == 5) {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 2) {
                        arrow.setStyle("-fx-background-image: url(/rsc/2arrowLeft.png)");
                        arrow.setClickCounter(3);
                    } else if (arrow.getClickCounter() == 3) {
                        arrow.setStyle("-fx-background-image: url(/rsc/3arrowUpLeft.png)");
                        arrow.setClickCounter(2);
                    }
                });
            } else {
                arrow.setOnAction(e -> {
                    if (arrow.getClickCounter() == 2) {
                        arrow.setStyle("-fx-background-image: url(/rsc/3arrowUpLeft.png)");
                        arrow.setClickCounter(3);
                    } else if (arrow.getClickCounter() == 3) {
                        arrow.setStyle("-fx-background-image: url(/rsc/1arrowDownLeft.png)");
                        arrow.setClickCounter(1);
                    } else {
                        arrow.setStyle("-fx-background-image: url(/rsc/2arrowLeft.png)");
                        arrow.setClickCounter(2);
                    }
                });
            }
        }
    }

}


