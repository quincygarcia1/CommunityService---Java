package mainGame;

import javafx.scene.input.KeyCode;

public class LeftAction implements Action {
	
	private GameView view;
	private KeyCode key;
	
	public LeftAction(GameView view, KeyCode key) {
		this.view = view;
		this.key = key;
	}
	
	public LeftAction(LeftAction left) {
		this.view = left.view;
		this.key = left.key;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.view.model.movePlayer.setDirection(false);
		this.view.model.startThread();
	}

	@Override
	public KeyCode getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

}
