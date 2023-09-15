
public class ValidQueueElement extends QueueElement{

	private String value;

	public ValidQueueElement(String value) {
        	this.value = value;
	}

	public getValue() {
		return value;
		
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
