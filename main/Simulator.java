package lab5.main;

/**
 * This program simulates a car wash.
 */

import java.util.Observable;

import lab5.event.EventQueue;
import lab5.event.SortedSequence;
import lab5.state.*;

public class Simulator extends Observable {

		public static int fastMachines = 2;
		public static int slowMachines = 2;
		public static double fastLow = 2.8;
		public static double fastHigh = 4.6;
		public static double slowLow = 3.5;
		public static double slowHigh = 6.7;
		public static double lambda = 2.0;
		public static long seed = 1234;
		public static int queueSize = 5;
		
		CarWashState carWashState = new CarWashState(queueSize, fastMachines,
				slowMachines, fastLow, fastHigh, slowLow, slowHigh, lambda,
				seed);
		
		String message = "";
		
		public static void main(String[] args) {

		if (!EventQueue.eventQueue.isEmpty()) { // When the event queue isn't empty...

			while (SimState.currentState != SimState.stop) {
				// When currentState isn't stop...

				if (SimState.currentState == SimState.start) { //When currentState is start...
					SortedSequence.startQueue(EventQueue.sendEvent()); //The first event will be sent.
					message = "Start"; //A message will be printed.
					setChanged();
					notifyObservers();
					
				} else if (SimState.currentState == SimState.leave) { //When the currentState is leave...
					EventQueue.eventQueue.removeFirst(); //The first event will be removed.
					message = "Leave"; //A message will be printed.
					setChanged();
					notifyObservers();
					
				} else if (SimState.currentState == SimState.arrive) { //When the currentState is arrive...
					EventQueue.eventQueue.addFirst(null);
					//EventQueue.newEvent(event); ISTÄLLET?
					message = "Arrive"; //A message will be printed.
					setChanged();
					notifyObservers();
				}
			}
			message = "Stop"; // When currentState is stop a message will be printed.
			SortedSequence.stop();
			EventQueue.eventQueue.clear();
			// The queue will be cleared.
			setChanged();
			notifyObservers();
			
		}
	}
}

