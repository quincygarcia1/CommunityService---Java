package utils;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;

public abstract class PowerUp extends GameButton {
	
	private int cost;
	private String title;
	
	public PowerUp (int cost, String title, int width, int height) {
		super(title, width, height, 20);
		this.cost = cost;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public void setTitle(KeyCode key) {
		this.setText(title);
	}

}
