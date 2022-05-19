package utils;

import java.util.ArrayList;
import java.util.List;

import mainGame.GameView;

public class DronePowerUp extends PowerUp{
	
	private static DronePowerUp instance;
	private int usages = 0;
	private List<Integer> costList = List.of(100, 700, 4000, 14000); 

	private DronePowerUp(GameView view) {
		super(100, "", 100, 30, view);
		// TODO Auto-generated constructor stub
		setTitle();
	}
	
	public static DronePowerUp getInstance(GameView view) {
		if (instance == null) {
			synchronized(DronePowerUp.class) {
				if (instance == null) {
					instance = new DronePowerUp(view);
				}
			}
		}
		return instance;
	}
	
	private void setTitle() {
		this.setTitle("" + this.costList.get(usages));
	}
	
	public void changeCost() {
		if (usages != 3) {
			this.setCost(this.costList.get(usages + 1));
		}
		this.usages ++;
		if (usages == 4) {
			this.setDisable(true);
		}
		setTitle();
	}

	@Override
	public void event() {
		// TODO Auto-generated method stub
		if (this.view.model.getScore() < this.getCost()) {
			return;
		}
		this.changeCost();
		this.view.newDrone();
	}


}
