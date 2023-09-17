package queue;

public class EmptyQueueElement extends QueueElement{
	
	public Object take() {
		throw new Error ("Queue is empty");
	}

	public Object head() {
		throw new Error ("Queue is empty");
	}
}
