package components.gameObjects;

import components.abstracts.Element;
import javafx.geometry.Pos;

public class Arrow extends Element {

	private int previousClickCounter;

	public Arrow(int cordX, int cordY) {
		setCordX(cordX);
		setCordY(cordY);
		this.setPrefWidth(100);
		this.setPrefHeight(100);
		this.setAlignment(Pos.CENTER);
		this.setId("arrowElement");
	}

	public int getPreviousClickCounter() {
		return previousClickCounter;
	}

	public void setPreviousClickCounter(int previousClickCounter) {
		this.previousClickCounter = previousClickCounter;
	}

	public void setArrowDown(Arrow arrow, int clickCounter) {
		arrow.setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
		arrow.setPreviousClickCounter(clickCounter);
		arrow.setClickCounter(0);
	}

	public void setArrowDownLeft(Arrow arrow, int clickCounter) {
		arrow.setStyle("-fx-background-image: url(/rsc/1arrowDownLeft.png)");
		arrow.setPreviousClickCounter(clickCounter);
		arrow.setClickCounter(1);
	}

	public void setArrowLeft(Arrow arrow, int clickCounter) {
		arrow.setStyle("-fx-background-image: url(/rsc/2arrowLeft.png)");
		arrow.setPreviousClickCounter(clickCounter);
		arrow.setClickCounter(2);
	}

	public void setArrowUpLeft(Arrow arrow, int clickCounter) {
		arrow.setStyle("-fx-background-image: url(/rsc/3arrowUpLeft.png)");
		arrow.setPreviousClickCounter(clickCounter);
		arrow.setClickCounter(3);
	}

	public void setArrowUp(Arrow arrow, int clickCounter) {
		arrow.setStyle("-fx-background-image: url(/rsc/4arrowUp.png)");
		arrow.setPreviousClickCounter(clickCounter);
		arrow.setClickCounter(4);
	}

	public void setArrowUpRight(Arrow arrow, int clickCounter) {
		arrow.setStyle("-fx-background-image: url(/rsc/5arrowUpRight.png)");
		arrow.setPreviousClickCounter(clickCounter);
		arrow.setClickCounter(5);
	}

	public void setArrowRight(Arrow arrow, int clickCounter) {
		arrow.setStyle("-fx-background-image: url(/rsc/6arrowRight.png)");
		arrow.setPreviousClickCounter(clickCounter);
		arrow.setClickCounter(6);
	}

	public void setArrowDownRight(Arrow arrow, int clickCounter) {
		arrow.setStyle("-fx-background-image: url(/rsc/7arrowDownRight.png)");
		arrow.setPreviousClickCounter(clickCounter);
		arrow.setClickCounter(7);
	}

	public void setArrowsAccordingToClickCounter(Arrow arrow, int arrowsClickCounter) {
		switch (arrowsClickCounter) {
			case 0:
				arrow.setStyle("-fx-background-image: url(/rsc/0arrowDown.png)");
				break;
			case 1:
				arrow.setStyle("-fx-background-image: url(/rsc/1arrowDownLeft.png)");
				break;
			case 2:
				arrow.setStyle("-fx-background-image: url(/rsc/2arrowLeft.png)");
				break;
			case 3:
				arrow.setStyle("-fx-background-image: url(/rsc/3arrowUpLeft.png)");
				break;
			case 4:
				arrow.setStyle("-fx-background-image: url(/rsc/4arrowUp.png)");
				break;
			case 5:
				arrow.setStyle("-fx-background-image: url(/rsc/5arrowUpRight.png)");
				break;
			case 6:
				arrow.setStyle("-fx-background-image: url(/rsc/6arrowRight.png)");
				break;
			case 7:
				arrow.setStyle("-fx-background-image: url(/rsc/7arrowDownRight.png)");
				break;
		}
	}
}
