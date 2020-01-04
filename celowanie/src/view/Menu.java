package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Menu extends VBox {

    private VBox menu;

    public Menu() {

        MenuButton saveFileButton = new MenuButton("Save");

        MenuButton openFileButton = new MenuButton("Load");

        MenuButton forwardButton = new MenuButton("Forward");

        MenuButton backButton = new MenuButton("Back");

        MenuButton helpButton = new MenuButton("Help");

        MenuButton exitGameButton = new MenuButton("Exit");
        exitGameButton.setOnAction(actionEvent -> {
            System.exit(0);
        });

        this.menu = new VBox();
        menu.getChildren().addAll(openFileButton, saveFileButton, forwardButton, backButton, helpButton, exitGameButton);
        menu.setSpacing(10);
        menu.setPadding(new Insets(0, 20, 0, 20));
        menu.setAlignment(Pos.TOP_CENTER);
        menu.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public VBox getMenu() {
        return menu;
    }

}
