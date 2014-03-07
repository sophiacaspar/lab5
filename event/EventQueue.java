package lab5.event;

/**
 * Denna klass skapar en kö för event, 'eventQueue' och bestämmer hur den ska sorteras och användas.
 * Kön används i Event.
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class EventQueue {

	public static LinkedList<Event> eventQueue = new LinkedList<Event>();
	// Skapar en lista som lägger till nästa event längst bak i kön.

	public static Event sendEvent() {
		Event first;
		
		if (eventQueue.isEmpty()) {
			throw new NoSuchElementException("The queue is empty.");
			// Om kön är tom så kommer ett felmeddelande att skrivas ut.
			
		} else {
			first = eventQueue.getFirst();
			eventQueue.removeFirst();
			return first;
			// Annars returneras det event som ligger först i kön samtidigt som
			// det tas bort ur kön.
		}
	}

	public static void newEvent(Event event) {
		if (eventQueue.isEmpty()) {
			eventQueue.addFirst(event);
			// Om kön är tom läggs objektet först i kön.
			
		} else {
			eventQueue.addLast(event);
			// Annars läggs objektet till sist i kön.
		}
	}

}
