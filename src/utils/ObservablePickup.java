package utils;

public interface ObservablePickup {
	
	void setObservingView(ObserverPickup op);
	void notifyObserver();
	void removeObservingView(ObserverPickup op);
	

}
