package gui;

import javafx.scene.control.Button;
import javafx.scene.image.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuButton extends Button {

    public MenuButton(String label, int width, String imgPath) throws FileNotFoundException {

        ImageView img = new ImageView(new Image(new FileInputStream(imgPath)));
        Button button = new Button(label, img);
        button.setPrefWidth(width);
    }
}
