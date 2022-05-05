package mainGame;

public abstract class Observable {
	
	private double observableState;
	
	public abstract void setObservingView(Observer o);
	public abstract void notifyObserver();
	public abstract void removeObservingView(Observer o);
	
	public double getObservableState() {
		return observableState;
	}
	
	public void setObservableState(double state) {
		this.observableState = state;
	}
	

}
