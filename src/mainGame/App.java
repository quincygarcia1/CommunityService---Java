package mainGame;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class App extends Application {
	
	Model model;
	GameView view;
	public int GAMEW = 1200;
	public int GAMEH = 700;
	
	public void start(Stage stage) {
		stage.setTitle("Community Service");
		stage.setMinHeight(GAMEH);
		stage.setMinWidth(GAMEW);
		
		this.model = new Model();
		this.view = new GameView(stage, model);
		
		LeftAction left = new LeftAction(view, KeyCode.A);
		RightAction right = new RightAction(view, KeyCode.D);
		CollectAction collect = new CollectAction(view, KeyCode.SPACE);
		this.view.setLeftKey(left);
		this.view.setRightKey(right);
		this.view.setCollectKey(collect);
		this.view.initStart();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

}
