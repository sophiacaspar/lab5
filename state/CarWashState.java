package lab5.state;

import lab5.random.*;

public class CarWashState extends SimState{
	public static final int max = 5;
	public static int currentstate;
	
	private UniformRandomStream fastRandom; //LAGT TILL
	private UniformRandomStream slowRandom;
	private ExponentialRandomStream exRandom;
	
	public FIFO queue = new FIFO();
	public CarFactory factory = new CarFactory();
	
	double idleTime, queueTime;
	
	public int getState(){
		return currentstate;
	}
	
	public CarWashState(int queueSize, int fastMachines, int slowMachines, double fastLow, double fastHigh, double slowLow, double slowHigh, double lambda, long seed){
		
	}
	
	public boolean checkWashing(){
		if(4== max){
			return true;
		}
		return false;
	}
	
	public float getTime(){
		return (float) 0.434;
	}
	

	
	
}
