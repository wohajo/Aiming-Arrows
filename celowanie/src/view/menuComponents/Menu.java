package view.menuComponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.MainGUI;
import view.buttons.MenuButton;

public class Menu extends VBox {

    private VBox vboxMenu;
    private MenuButton startGameButton;
    private MenuButton saveFileButton;
    private MenuButton openFileButton;
    private MenuButton editBoardButton;
    private MenuButton forwardButton;
    private MenuButton backButton;
    private MenuButton helpButton;
    private MenuButton exitGameButton;

    public Menu() {

        Label gameLabel = new Label("Game");

        this.startGameButton = new MenuButton("Start");

        this.saveFileButton = new MenuButton("Save");

        this.openFileButton = new MenuButton("Load");

        this.editBoardButton = new MenuButton("Edit");

        Label historyLabel = new Label("History");

        this.forwardButton = new MenuButton("Forward");

        this.backButton = new MenuButton("Back");

        Label controlsLabel = new Label("Controls");

        this.helpButton = new MenuButton("Help");

       this.exitGameButton = new MenuButton("Exit");

        this.vboxMenu = new VBox();
        vboxMenu.getChildren().addAll(gameLabel, startGameButton, openFileButton, saveFileButton, editBoardButton, historyLabel, forwardButton, backButton, controlsLabel, helpButton, exitGameButton);
        vboxMenu.setSpacing(10);
        vboxMenu.setPadding(new Insets(0, 20, 0, 20));
        vboxMenu.setAlignment(Pos.TOP_CENTER);
        vboxMenu.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public VBox getVboxMenu() {
        return vboxMenu;
    }

    public MenuButton getStartGameButton() {
        return startGameButton;
    }

    public MenuButton getOpenFileButton() {
        return openFileButton;
    }

    public MenuButton getSaveFileButton() {
        return saveFileButton;
    }

    public MenuButton getEditBoardButton() {
        return editBoardButton;
    }

    public MenuButton getForwardButton() {
        return forwardButton;
    }

    public MenuButton getBackButton() {
        return backButton;
    }

    public MenuButton getHelpButton() {
        return helpButton;
    }

    public MenuButton getExitGameButton() {
        return exitGameButton;
    }
}

