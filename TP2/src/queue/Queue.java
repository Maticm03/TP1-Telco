package queue;

import java.util.LinkedList;

public class Queue {
  private LinkedList<Object> queue = new LinkedList<>();
  	public boolean isEmpty() {
	  return queue.isEmpty();
	}
//en isEmpty decía que tenía que devolver True.
	public Queue add( Object  cargo ) {
	  queue.add(cargo);
		return this;
	}

	public Object take() {
	  if (isEmpty()) {
		throw new IllegalStateException("La cola está vacía");
	    }
	    queue.removeFirst(); // Elimina el elemento del frente de la cola
	    return this;
	}
//take devolvía null.
	public Object head() {
	  
		return null;
	}

	public int size() {
	  
		return 0;
	}
}
