package lab5.event;

/**
 * This class contains different methods which starts the simulation. It will, for example add and send out new events.
 */

import lab5.state.CarWashState;

public class SortedSequence {
	public static EventQueue eventQueue;
	public static CarWashState currentStates;
	public static SortedSequence s;
	private static boolean running = true;

	public SortedSequence(CarWashState currentState) {
		currentStates = currentState;
		eventQueue = new EventQueue();
		s = this;
	}

	public void addToQueue(Event event) {
		eventQueue.newEvent(event); // Adds a new event to the queue under the
									// conditions that is in EventQueue.
	}

	public void startQueue(Event event) {
		addToQueue(event);
		run();
	}

	public void run() {
		while (running) {
			Event e = EventQueue.sendEvent();
			e.execute(currentStates, s); // While the car wash runs new events
											// will be sent sequentially under
											// the conditions that is in
											// EventQueue.
		}
	}

	public void stop() {
		running = false;
	}
}
