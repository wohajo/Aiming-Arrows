package components.gameObjects;

import components.abstracts.Element;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Arrow extends Element {

	public Arrow(int cordX, int cordY) {
		setCordX(cordX);
		setCordY(cordY);
		this.setPrefWidth(100);
		this.setPrefHeight(100);
		this.setAlignment(Pos.CENTER);
		this.setId("arrowElement");
	}
}
