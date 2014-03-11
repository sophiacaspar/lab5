package lab5.main;

import lab5.event.*;
import lab5.state.CarWashState;
import lab5.view.CarWashView;

public class Simulator_new {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int fastMachines = 2;
		int slowMachines = 2;
		double fastLow = 2.8;
		double fastHigh = 4.6;
		double slowLow = 3.5;
		double slowHigh = 6.7;
		double lambda = 2.0;
		long seed = 1234;
		int queueSize = 5;
		
		CarWashState carWashState = new CarWashState(queueSize, fastMachines, slowMachines, fastLow, fastHigh, slowLow, slowHigh, lambda, seed);
		
    	SortedSequence sortSeq = new SortedSequence(carWashState);
    	CarWashView carWashView = new CarWashView();
    	carWashState.addObserver(carWashView);
    	sortSeq.addToQueue(new Stop(15));
    	sortSeq.startQueue(new Start(0));
	}

}
