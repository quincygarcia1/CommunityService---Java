package utils;

import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import mainGame.GameView;

public abstract class PowerUp extends GameButton {
	
	private int cost;
	private String title;
	public int usages = 0;
	public GameView view;
	
	public PowerUp (int cost, String title, int width, int height, GameView view) {
		super(title, width, height, 20);
		this.view = view;
		this.cost = cost;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setCost(int newCost) {
		this.cost = newCost;
	}
	
	public void setTitle(String title) {
		this.setText(title);
	}
	
	public abstract void changeCost();
}
