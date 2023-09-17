package queue;

public class EmptyQueueElement extends QueueElement{
	
	public static String QueueIsEmpty = "Queue is empty";

	public Object take() {
		throw new RuntimeException (QueueIsEmpty);
	}

	public Object head() {
		throw new RuntimeException (QueueIsEmpty);
	}
}
