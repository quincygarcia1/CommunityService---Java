package mainGame;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameView {
	
	Stage stage;
	Model model;
	BorderPane borderPane;
		
	public GameView(Stage stage, Model model) {
			this.stage = stage;
			this.model = model;
			initStart();
	}
	
	public void initStart() {
		borderPane = new BorderPane();
		
		showMenu();
		
		Scene scene = new Scene(borderPane, 1000, 700);
		stage.setScene(scene);
		stage.show();
	}
	
	private void showMenu() {
		StartMenu menu = new StartMenu(this);
		VBox box = new VBox(10, menu);
		box.setAlignment(Pos.CENTER);
		borderPane.setCenter(box);
	}
	
}
