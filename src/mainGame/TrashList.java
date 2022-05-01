package mainGame;

public class TrashList {
	
	public boolean assigned;
	Collectable item;
	public TrashList next;
	private int key;
	

	public TrashList(Collectable item, int key) {
		this.assigned = false;
		this.item = item;
		this.next = null;
		this.key = key;
	}
	
	public void droneSet() {
		this.assigned = true;
	}
	
	public int getKey() {
		return this.key;
	}
}
