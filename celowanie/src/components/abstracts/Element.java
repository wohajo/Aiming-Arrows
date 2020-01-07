package components.abstracts;

import javafx.scene.Node;
import javafx.scene.control.Button;

public abstract class Element extends Button {

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
		this.cordX = cordY;
	};

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void valueInc() {
		if(this.value > 8)
			this.value = 0;
		else
			this.value ++;
	}

	public void valueDec() {
		this.value --;
	}
}
