package components.abstracts;

import javafx.scene.control.Button;

public abstract class Element extends Button {

	int cordX;
	int cordY;

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
}
