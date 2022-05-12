package sprites;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.scene.image.Image;
import utils.ObserverPickup;

public class PileItem extends Collectable{
	
	static Random rand = new Random();

	public PileItem() {
		super(new ArrayList<Image>(Arrays.asList(new Image("file:Images/BigGarbage-Undamaged.png"),
				new Image("file:Images/BigGarbage-Destroyed.png"))), rand.nextInt(5) + 3, 350);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setObservingView(ObserverPickup op) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObservingView(ObserverPickup op) {
		// TODO Auto-generated method stub
		
	}
	
	

}
