package lab5.main;

import lab5.state.*;

public class Simulator {
	public void main(String[] args){
    	int fastMachines =2;
    	int slowMachines =2;
    	double fastLow = 2.8;
    	double fastHigh = 4.6;
    	double slowLow = 3.5;
    	double slowHigh = 6.7;
    	double lambda = 2.0;
    	long seed = 1234;
    	int queueSize = 5;
    	CarWashState carWashState = new CarWashState(queueSize, fastMachines, slowMachines, fastLow, fastHigh, slowLow, slowHigh, lambda, seed);
    	
		while (SimState.currentState != SimState.stop){
			
		}
	}
}
