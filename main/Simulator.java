package lab5.main;

/**
 * Detta program simmulerar en biltvÃ¤tt.
 */

import java.util.Observable;

import lab5.event.Event;
import lab5.event.SortedSequence;
import lab5.event.Start;
import lab5.state.*;
import lab5.view.CarWashView;

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
		public static double late = 15.00;
		
		public Event event;
		public static SortedSequence sortSeq;
		public static CarWashState carWashState;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			carWashState = new CarWashState(queueSize, fastMachines, slowMachines, fastLow, fastHigh, slowLow, slowHigh, lambda, seed);
			sortSeq = new SortedSequence(carWashState);
	    	CarWashView carWashView = new CarWashView();
	    	carWashState.addObserver(carWashView);
	    	sortSeq.startQueue(new Start(0));
		}
	}
