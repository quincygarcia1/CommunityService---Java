package utils;

import java.util.ArrayList;
import java.util.List;

import mainGame.GameView;

public class MultiplierPowerUp extends PowerUp{

	private static MultiplierPowerUp instance;
	private List<Integer> costList = List.of(20, 80, 500, 3000);
	private List<Integer> multipliers = List.of(4, 16, 64, 256);
	private int currentMultiplier = 1;
	
	private MultiplierPowerUp(GameView view) {
		super(20, "", 100, 30, view);
		// TODO Auto-generated constructor stub
		setTitle();
	}
	
	public static MultiplierPowerUp getInstance(GameView view) {
		if (instance == null) {
			synchronized(DronePowerUp.class) {
				if (instance == null) {
					instance = new MultiplierPowerUp(view);
				}
			}
		}
		return instance;
	}
	
	private void setTitle() {
		this.setTitle("" + this.costList.get(usages));
	}

	@Override
	public void changeCost() {
		// TODO Auto-generated method stub
		if (usages != 3) {
			this.setCost(this.costList.get(usages + 1));
		}
		currentMultiplier = multipliers.get(usages); 
		usages ++;
		if (usages == 4) {
			this.setDisable(true);
		}
		setTitle();
	}
	
	public int getMultiplier() {
		return this.currentMultiplier;
	}
	
}
