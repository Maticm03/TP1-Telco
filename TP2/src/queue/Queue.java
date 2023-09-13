package queue;

import java.util.LinkedList;
import java.util.List;

public class Queue {
  private List <QueueElement> elements = new LinkedList<>();
  
  public Queue () {
	  elements.add(new EmptyQueueElement())
  }
  public boolean isEmpty() {
		return elements.size() == 1;
	}

	public Queue add( QueueElement element ) {
		elements.add(elements.size() - 1 , element); 
		// Agrega el elemento antes que el elemento vacio (o sea el vacio esta siempre al final).
		return this;
	}

	public QueueElement take() {
	// Deberia fijarse de que clase es el primer elemento de la lista y en base a eso ir al método de la clase que corresponde para devolve el valor o mensaje correcto
	// elements.get(1) no se si va a la clase
		return null;
	}

	public QueueElement head() {
		// Mismo que take
		// elements.get(1)
		return null;
	}

	public int size() {
		// Creo que no depende de la clase del elemento pero el ultimo que es el vacio no lo tiene que contar.
		return elements.size() - 1;
	}

}
