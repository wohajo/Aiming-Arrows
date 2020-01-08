package components.abstracts;

import javafx.scene.Node;
import javafx.scene.control.Button;

public abstract class Element extends Button {

	int clickCounter = 0;
	int cordX;
	int cordY;
	int value = 0;

	public int getCordX() {
		return cordX;
	};

	public int getCordY() {
		return cordY;
	};

	public void setCordX(int cordX) {
		this.cordX = cordX;
	};

	public void setCordY(int cordY) {
		this.cordY = cordY;
	};

	public int getClickCounter() {
		return clickCounter;
	}

	public void setClickCounter(int clickCounter) {
		this.clickCounter = clickCounter;
	}

	public void clickCounterInc() {
		this.clickCounter ++;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void valueInc() {
		if(this.value == 8)
			this.value = 0;
		else
			this.value ++;
	}

	public void valueDec() {
		this.value --;
	}
}
