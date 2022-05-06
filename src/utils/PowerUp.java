package utils;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;

public abstract class PowerUp extends Button {
	
	private int cost;
	private String title;
	
	public PowerUp (int cost, String title) {
		super(title);
		this.cost = cost;
		Font btnFont = Font.l
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public void setTitle(KeyCode key) {
		this.setText(title);
	}

}
