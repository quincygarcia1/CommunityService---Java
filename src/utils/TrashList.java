package utils;

import sprites.Collectable;

public class TrashList {
	
	public boolean assigned;
	private Collectable item;
	public TrashList next;
	

	public TrashList(Collectable item) {
		this.assigned = false;
		this.item = item;
		this.next = null;
	}
	
	public void droneSet() {
		this.assigned = true;
	}
	
	public Collectable getItem() {
		return this.item;
	}
	
}
