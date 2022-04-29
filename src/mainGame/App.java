package mainGame;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	
	Model model;
	GameView view;
	public int GAMEW = 1000;
	public int GAMEH = 700;
	
	public void start(Stage stage) {
		stage.setTitle("Community Service");
		stage.setMinHeight(GAMEH);
		stage.setMinWidth(GAMEW);
		
		this.model = new Model();
		this.view = new GameView(stage, model);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
