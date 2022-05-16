package utils;

import java.util.List;

public class MovementPowerUp extends PowerUp{

	private static MovementPowerUp instance;
	private List<Integer> costList = List.of(40, 100, 600, 2000);
	private List<Integer> speeds = List.of(5, 6, 7, 8);
	private int currentSpeed = 4;
	
	public MovementPowerUp() {
		super(40, "", 100, 30);
		// TODO Auto-generated constructor stub
		setTitle();
	}
	
	public static MovementPowerUp getInstance() {
		if (instance == null) {
			synchronized(MovementPowerUp.class) {
				if (instance == null) {
					instance = new MovementPowerUp();
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
		currentSpeed = speeds.get(usages); 
		usages ++;
		if (usages == 4) {
			this.setDisable(true);
		}
		setTitle();
	}
	
	public int getCurrentSpeed() {
		return this.currentSpeed;
	}

}
