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

	public void setArrowDown(Arrow arrow) {
		arrow.setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
		arrow.setClickCounter(0);
	}

	public void setArrowDownLeft(Arrow arrow) {
		arrow.setStyle("-fx-background-image: url(/rsc/1arrowDownLeft.png)");
		arrow.setClickCounter(1);
	}

	public void setArrowLeft(Arrow arrow) {
		arrow.setStyle("-fx-background-image: url(/rsc/2arrowLeft.png)");
		arrow.setClickCounter(2);
	}

	public void setArrowUpLeft(Arrow arrow) {
		arrow.setStyle("-fx-background-image: url(/rsc/3arrowUpLeft.png)");
		arrow.setClickCounter(3);
	}

	public void setArrowUp(Arrow arrow) {
		arrow.setStyle("-fx-background-image: url(/rsc/4arrowUp.png)");
		arrow.setClickCounter(4);
	}

	public void setArrowUpRight(Arrow arrow) {
		arrow.setStyle("-fx-background-image: url(/rsc/5arrowUpRight.png)");
		arrow.setClickCounter(5);
	}

	public void setArrowRight(Arrow arrow) {
		arrow.setStyle("-fx-background-image: url(/rsc/6arrowRight.png)");
		arrow.setClickCounter(6);
	}

	public void setArrowDownRight(Arrow arrow) {
		arrow.setStyle("-fx-background-image: url(/rsc/7arrowDownRight.png)");
		arrow.setClickCounter(7);
	}
}
