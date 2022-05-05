package mainGame;

import javafx.scene.input.KeyCode;

public class CollectAction implements Action{
	
	private GameView view;
	private KeyCode key;
	
	public CollectAction(GameView view, KeyCode key) {
		this.view = view;
		this.key = key;
	}
	
	public CollectAction(CollectAction action) {
		this.view = action.view;
		this.key = action.key;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.view.collectNearest();
		this.view.model.movePlayer.setCollecting(true);
		this.view.model.startThread();
	}

	@Override
	public KeyCode getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

}
