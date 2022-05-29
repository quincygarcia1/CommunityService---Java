package utils;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TrashTimer extends Observable {

	private Observer view;
	private double secondsLeft;
	private double millisecondsLeft;
	private boolean hasStarted;
	private int offset;
	private Timer timer;
	Random rand = new Random();
	
	public TrashTimer() {
		offset = 12;
		this.secondsLeft = (rand.nextInt(this.offset/3) + 1) + (this.offset - (this.offset/4));
		this.millisecondsLeft = rand.nextInt(1000);
		this.setObservableState(secondsLeft + (millisecondsLeft/1000));
		this.hasStarted = false;
	}

	@Override
	public void setObservingView(Observer o) {
		// TODO Auto-generated method stub
		this.view = o;
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		timer = new Timer();
		hasStarted = true;
		
		TimerTask task = new TimerTask() {
			public void run() {
				if (millisecondsLeft == 0) {
					millisecondsLeft = 1000;
					secondsLeft -= 1;
				}
				millisecondsLeft -= 1;
				view.update(secondsLeft + (millisecondsLeft/1000));
				if (secondsLeft == 0 && millisecondsLeft == 0) {
					stopTimer();
				}
			}
		};
		
		timer.scheduleAtFixedRate(task, 0, 1);
		
	}

	@Override
	public void removeObservingView(Observer o) {
		// TODO Auto-generated method stub
		this.view = null;
	}
	
	public void stopTimer() {
		timer.cancel();
		timer.purge();
	}
	
	public void resetTimer() {
		this.secondsLeft = (double)(rand.nextInt(this.offset/3) + 1) + (this.offset - (this.offset/4));
		this.millisecondsLeft = rand.nextInt(1000);
		this.setObservableState(secondsLeft + ((double)millisecondsLeft/1000));
		this.hasStarted = false;
	}
	
	public void changeOffset(int newOffset) {
		this.offset = newOffset;
	}
	
	
}
