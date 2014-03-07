package lab5.state;

import lab5.random.*;

public class CarWashState extends SimState{
	public static final int max = Simulator.queueSize;
	public static int currentstate;
	private static long seed = Simulator.seed;
	
	private static UniformRandomStream fastRandom; //LAGT TILL
	private static UniformRandomStream slowRandom;
	private static ExponentialRandomStream exRandom;
	
	public FIFO queue = new FIFO();
	public CarFactory factory = new CarFactory();
	
	double idleTime, queueTime;
	
	public int getState(){
		return currentstate;
	}
	
	public CarWashState(int queueSize, int fastMachines, int slowMachines, double fastLow, double fastHigh, double slowLow, double slowHigh, double lambda, long seed){
		
	}
	public static void fast(int fastMachines, double fastLow, double fastHigh){
		while(fastMachines != 0 ){
			fastRandom = getTime(fastLow, fastHigh);
			fastMachines --;
		}
	}
	public static void slow(int slowMachines, double slowLow, double slowHigh){
		while(slowMachines != 0 ){
			slowRandom = getTime(slowLow, slowHigh);
			slowMachines --;
		}
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
