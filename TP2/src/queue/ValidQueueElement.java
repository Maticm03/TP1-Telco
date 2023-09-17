package queue;

public class ValidQueueElement extends QueueElement{
	
	private Object value;

	public ValidQueueElement(Object value) {
        	this.value = value;
	}
	
	public Object take() {
		return value;
	}
	
	public Object head() {
		return value;
	}
	
}
