
public class ValidQueueElement extends QueueElement{
	public boolean isEmpty() {
		return false
	}
	
	public Object take() {
		Object removedItem = queue.removeFirst();
		return removedItem;
	}
	
	public Object head() {
		Object firstItem = queue.getFirst();
		return firstItem;
	}
	
}
