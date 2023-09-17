package queue;

public abstract class QueueElement {
	public abstract Object take();
	public abstract Object head ();
	private Object value;
}
