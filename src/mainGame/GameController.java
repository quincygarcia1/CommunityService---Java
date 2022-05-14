package mainGame;

import java.util.ArrayList;
import java.util.Hashtable;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import sprites.Collectable;
import sprites.Sprite;

public class GameController extends Pane {

	private final GameView view;
	private final Model model;
	private Text scoreDisplay;
	
	public GameController(GameView view, Model model) {
		this.view = view;
		this.model = model;
		this.setPrefSize(1200, 700);
		this.setMinSize(1200, 700);
		this.setMaxSize(1200, 700);
		Image backdropImage = new Image("file:Images/Backdrop.png");
		BackgroundImage backgroundimage = new BackgroundImage(backdropImage, 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundRepeat.NO_REPEAT, 
                BackgroundPosition.DEFAULT, 
                   BackgroundSize.DEFAULT);
		Background background = new Background(backgroundimage);
		this.setBackground(background);
		scoreDisplay = new Text(120, 690, "" + this.model.score);
		createScreen();
	}
	
	private void createScreen() {
		this.getChildren().add(this.model.movePlayer);
		this.getChildren().add(scoreDisplay);
	}
	
	protected void removeElement(Sprite sprite) {
		this.getChildren().remove(sprite);
	}
	
	protected void addElement(Sprite sprite) {
		this.getChildren().add(sprite);
		this.getChildren().get(this.getChildren().size() - 1).toBack();
	}
}
