package mainGame;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameView {
	
	Stage stage;
	Model model;
	BorderPane borderPane;
	GameController gamePane;
	Random rand = new Random();
	boolean gameStarted = false;
	private Action leftKey;
	private Action rightKey;
	private Action collectKey;
	private ArrayList<Action> commandQueue;
		
	public GameView(Stage stage, Model model) {
			this.stage = stage;
			this.model = model;
			this.commandQueue = new ArrayList<Action>();
	}
	
	public void initStart() {
		borderPane = new BorderPane();
		
		showMenu();
		
		var scene = new Scene(borderPane, 1000, 700);
		
		scene.setOnKeyPressed(e -> {
			if (gameStarted && e.getCode() == leftKey.getKey()) {
				this.commandQueue.add(leftKey);
				leftKey.execute();
				this.commandQueue.remove(leftKey);
			}
			if (gameStarted && e.getCode() == rightKey.getKey()) {
				this.commandQueue.add(rightKey);
				rightKey.execute();
				this.commandQueue.remove(rightKey);
			}
			if (gameStarted && e.getCode() == collectKey.getKey()) {
				this.commandQueue.add(collectKey);
				collectKey.execute();
				this.commandQueue.remove(collectKey);
			}
		});
		
		stage.setScene(scene);
		stage.show();
	}
	
	private void showMenu() {
		StartMenu menu = new StartMenu(this);
		VBox box = new VBox(10, menu);
		box.setAlignment(Pos.CENTER);
		borderPane.setCenter(box);
	}
	
	protected void showGameScreen() {
		gamePane = new GameController(this, model);
		VBox box = new VBox(gamePane);
		box.setAlignment(Pos.CENTER);
		borderPane.setCenter(box);
	}
	
	protected void setLeftKey(Action action) {
		this.leftKey = action;
	}
	
	protected void setRightKey(Action action) {
		this.rightKey = action;
	}
	
	protected void setCollectKey(Action action) {
		this.collectKey = action;
	}
	
	private void spawnTrash() {
		if (this.model.trashCount > 40) {
			return;
		}
		TrashList newElement = null;
		int garbageType = rand.nextInt(3);
		if (garbageType == 0) {
			newElement = new TrashList(new PileItem());
		} else if (garbageType > 0) {
			newElement = new TrashList(new garbageItem());
		}
		this.model.registerTrash(newElement);
	}
	
	protected void collectNearest() {
		Collectable nearest = this.model.checkProximity();
		if (nearest == null) {
			return;
		}
	}
	
}
