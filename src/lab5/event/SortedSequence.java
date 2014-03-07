package lab5.event;

/**
 * Denna klass innehåller olika metoder som sätter igång själva simulationen. Tex. lägger till och skickar ut nya event.
 */

import lab5.state.SimState;

public class SortedSequence {
	public EventQueue eventQueue;
	public SimState currentState;
	public static boolean running;

	public SortedSequence(SimState currentState) {
		this.currentState = currentState;
		eventQueue = new EventQueue();
	}

	public static void addToQueue(Event event) {
		EventQueue.newEvent(event); // Lägger till ett nytt event till kön under
									// de förutsättningar som finns i
									// EventQueue.
	}

	public static void startQueue(Event event) {
		addToQueue(event);
		run();
	}

	public static void run() {
		running = true; // När tvätten körs blir running true.
		while (running) {
			Event e = EventQueue.sendEvent();
			e.execute(currentState, this); // När biltvätten körs kommer hela
											// tiden (i tur och ordning) nya
											// event skickas under de
											// förutsättningar som finns i
											// EventQueue.
		}
	}

	public static void stop() {
		running = false; // När tvätten inte körs blir running false.
	}
}
