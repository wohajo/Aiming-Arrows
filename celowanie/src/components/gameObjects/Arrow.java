package components.gameObjects;

import components.abstracts.Element;

public class Arrow extends Element {

	int clickCounter;

	public Arrow(int cordX, int cordY) {
		this.clickCounter = 0;
		setCordX(cordX);
		setCordY(cordY);

	}

	public int getClickCounter() {
		return clickCounter;
	}	
	
}
