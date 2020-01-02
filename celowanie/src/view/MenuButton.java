package view;

import javafx.scene.control.Button;
import javafx.scene.image.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuButton extends Button {

    public MenuButton(String label, int width) throws FileNotFoundException {
        super(label);
        this.setPrefWidth(width);
    }
}
