package lab5.event;

/**
 * This class creates a queue for events, 'eventQueue' and decides how they will be sorted and used.
 * The queue will be used in event.
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class EventQueue {

	public static LinkedList<Event> eventQueue = new LinkedList<Event>();
	// Creates a list that will put the next event at the back of the queue.

	public static Event sendEvent() {
		Event first;

		if (eventQueue.isEmpty()) {
			throw new NoSuchElementException("The queue is empty.");
			// If the queue is empty an error message will be printed.

		} else {
			first = eventQueue.getFirst();
			eventQueue.removeFirst();
			return first;
			//Else the first event in the queue will be returned and then removed.
		}
	}

	public void newEvent(Event event) {
		if (eventQueue.isEmpty()) {
			eventQueue.addFirst(event);
			// If the queue is empty the object will be put first.

		} else {
			eventQueue.addLast(event);
			// Else it will be put last.
		}
	}

}
