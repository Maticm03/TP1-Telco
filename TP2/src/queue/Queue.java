package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
  private List <QueueElement> elements = new ArrayList<>();
  private QueueElement headElement = new EmptyQueueElement();
  
  public Queue () {
	  elements.add(headElement);
  }
  
  public boolean isEmpty() {
		return elements.size() == 1;
	}

	public Queue add( String value ) {
		QueueElement element = new ValidQueueElement(value);
		elements.add(1, element); 
		return this;
	}

	public Object take() {
		QueueElement removedElement = elements.remove(elements.size()-1);
		return removedElement.take();
	}

	public Object head() {
		return elements.get(elements.size()-1).head();
	}

	public int size() {
		return elements.size() - 1;
	}

}
