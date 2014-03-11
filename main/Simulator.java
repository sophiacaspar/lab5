package lab5.main;

/**
 * This program simulates a car wash.
 */

import lab5.event.*;
import lab5.state.CarWashState;
import lab5.view.CarWashView;

public class Simulator {

	/**
	 * Here we set some variables which is used on other parts of the code.
	 */

	public static int fastMachines = 2;
	public static int slowMachines = 2;
	public static double fastLow = 2.8;
	public static double fastHigh = 4.6;
	public static double slowLow = 3.5;
	public static double slowHigh = 6.7;
	public static double lambda = 2.0;
	public static long seed = 1234;
	public static int queueSize = 5;

	public static void main(String[] args) {

		CarWashState carWashState = new CarWashState(queueSize, fastMachines,
				slowMachines, fastLow, fastHigh, slowLow, slowHigh, lambda,
				seed);

		SortedSequence sortSeq = new SortedSequence(carWashState);
		
		CarWashView carWashView = new CarWashView();
		
		carWashState.addObserver(carWashView); //Starts addObserver.
		sortSeq.addToQueue(new Stop(15)); //Determines for how long the simulation will run.
		sortSeq.startQueue(new Start(0)); //Starts the simulation.
	}

}
