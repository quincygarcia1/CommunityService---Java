package mainGame;

import javafx.scene.control.Button;

public abstract class PowerUp extends Button {
	
	private int cost;
	
	public PowerUp (int cost, String title) {
		super(title);
		this.cost = cost;
	}
	
	public abstract void handle();
	
	public int getCost() {
		return this.cost;
	}

}
