package mainGame;

import javafx.scene.input.KeyCode;
import sprites.Collectable;
import utils.Action;

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
		Collectable res = this.view.collectNearest();
		if (res == null) {
			return;
		}
		this.view.model.movePlayer.setTarget(res);
		this.view.model.movePlayer.setCollecting(true);
		res.setObservingView(view);
		this.view.model.startThread();
		this.view.model.startGarbageThread();
	}

	@Override
	public KeyCode getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

}
