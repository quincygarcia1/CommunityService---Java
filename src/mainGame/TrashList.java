package mainGame;

public class TrashList {
	
	public boolean assigned;
	Collectable item;
	public TrashList next;
	

	public TrashList(Collectable item) {
		this.assigned = false;
		this.item = item;
		this.next = null;
	}
	
	public void droneSet() {
		this.assigned = true;
	}
}
