package mainGame;

import javafx.scene.input.KeyCode;

public class RightAction implements Action {

	private GameView view;
	private KeyCode key;
	
	public RightAction(GameView view, KeyCode key) {
		this.view = view;
		this.key = key;
	}
	
	public RightAction(RightAction left) {
		this.view = left.view;
		this.key = left.key;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KeyCode getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}
}
