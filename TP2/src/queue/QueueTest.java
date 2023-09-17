package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class QueueTest {

  @Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( new Queue().add( "Something" ).isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( "Something", new Queue().add( "Something" ).head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = queueAddsSomething();
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = queueAddsSomething();
    
    assertEquals( "Something", queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = queueAddsFirstAndSecondObject();

    assertEquals( queue.take(), "First" );
    assertEquals( queue.take(), "Second" );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = queueAddsFirstAndSecondObject();

    assertEquals( queue.head(), "First" );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = queueAddsSomething();
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new Queue().add( "First" ).add( "Second" ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    assertThrowsLike( () -> queue.take(),EmptyQueueElement.QueueIsEmpty);
  }


private void assertThrowsLike(Executable executable, String message) {
	assertEquals( message,
            assertThrows( RuntimeException.class, executable ).getMessage() );
	
}

@Test public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = queueAddsSomething();
    queue.take();
    assertThrowsLike( () -> queue.take(),EmptyQueueElement.QueueIsEmpty);
  }

  @Test public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    assertThrowsLike( () -> queue.head(),EmptyQueueElement.QueueIsEmpty);
   }
  
  private Queue queueAddsSomething() {
		Queue queue = new Queue();
	    queue.add( "Something" );
		return queue;
	}
  
  private Queue queueAddsFirstAndSecondObject() {
		Queue queue = new Queue();
	    queue.add( "First" );
	    queue.add( "Second" );
		return queue;
	}
}