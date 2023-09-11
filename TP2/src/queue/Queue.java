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
	        throw new Error("Queue is empty");
	    }
	    
	    Object removedItem = queue.removeFirst(); // Elimina y almacena el elemento del frente de la cola
	    return removedItem; // Devuelve el elemento eliminado
	}

//take devolvía null.
	
	public Object head() {
	    if (isEmpty()) {
	        throw new Error("Queue is empty");
	    }
	    
	    return queue.getFirst();
	}
	
	public int size() {
	    return queue.size(); // Devuelve el tamaño de la cola
	}


}
