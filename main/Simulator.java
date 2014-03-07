package lab5.main;

/**
 * Detta program simmulerar en biltvätt.
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
		
		public void main(String[] args) {

		if (!EventQueue.eventQueue.isEmpty()) { //När eventkön inte är tom...

			while (SimState.currentState != SimState.stop) {
				//När currentstate inte är stop...

				if (SimState.currentState == SimState.start) {
					SortedSequence.startQueue(EventQueue.sendEvent());
					message = "Start";
					setChanged();
					notifyObservers();
					
				} else if (SimState.currentState == SimState.leave) {
					EventQueue.eventQueue.removeFirst();
					message = "Leave";
					setChanged();
					notifyObservers();
					
				} else if (SimState.currentState == SimState.arrive) {
					EventQueue.eventQueue.addFirst(null);
					message = "Arrive";
					setChanged();
					notifyObservers();
				}
			}
			message = "Stop";
			SortedSequence.stop();
			EventQueue.eventQueue.clear();
			//När currentstate är stop så töms listan.
			setChanged();
			notifyObservers();
			
		}
	}
}

