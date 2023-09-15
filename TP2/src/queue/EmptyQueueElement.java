
public class EmptyQueueElement extends QueueElement{

	public String getValue(){
		return "";
	}
	
	public boolean isEmpty() {
		return true;
	}
	
	public QueueElement take() {
		throw new IllegalStateException("Queue is empty");
	}
	
	public QueueElement head() {
		throw new IllegalStateException("Queue is empty");
	}
	
}
