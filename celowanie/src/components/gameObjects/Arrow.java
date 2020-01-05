package components.gameObjects;

import components.abstracts.Element;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Arrow extends Element {

	private int clickCounter;

	public Arrow(int cordX, int cordY) {
		this.setPrefWidth(100);
		this.setPrefHeight(100);
		this.setAlignment(Pos.CENTER);
		this.setId("arrowElement");
		this.clickCounter = 0;
		setCordX(cordX);
		setCordY(cordY);

	}

	public int getClickCounter() {
		return clickCounter;
	}

	public void setClickCounter(int clickCounter) {
		this.clickCounter = clickCounter;
	}
}
