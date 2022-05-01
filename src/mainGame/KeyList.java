package mainGame;

public class KeyList {
	private int key;
	private KeyList next;
	
	public KeyList(int key) {
		this.key = key;
		this.next = null;
	}
	
	protected void setNext(KeyList next) {
		this.next = next;
	}
	
	protected KeyList getNext() {
		return this.next;
	}
	
	protected int getKey() {
		return this.key;
	}

}
