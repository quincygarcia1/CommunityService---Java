package mainGame;

import java.util.ArrayList;
import java.util.Hashtable;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;

public class GameController extends Pane {

	private final GameView view;
	private final Model model;
	private Hashtable<Integer, Collectable> trashHash = new Hashtable<Integer, Collectable>(40);
	
	public GameController(GameView view, Model model) {
		this.view = view;
		this.model = model;
		this.setPrefSize(1000, 700);
		this.setMinSize(1000, 700);
		this.setMaxSize(1000, 700);
		createScreen();
	}
	
	private void createScreen() {
		this.getChildren().add(this.model.movePlayer);
	}
	
	
	public void update() {
		
	}
}
