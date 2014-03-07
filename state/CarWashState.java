package lab5.state;

import lab5.main.Simulator;
import lab5.random.*;

public class CarWashState extends SimState{

	public static int max;
	public static int currentstate;
	private static long seed = Simulator.seed;
	
	public static UniformRandomStream fastRandom; 
	public static UniformRandomStream slowRandom;
	public static ExponentialRandomStream exRandom;
	private static UniformRandomStream Time;
	
	public FIFO queue = new FIFO();
	public CarFactory factory = new CarFactory();
	
	double idleTime, queueTime;
	
	public int getState(){
		return currentstate;
	}
	
	public CarWashState(CarWashState machine) {
		super(machine);
		// TODO Auto-generated constructor stub
	}
//	public CarWashState(int queueSize, int fastMachines, int slowMachines, double fastLow, double fastHigh, double slowLow, double slowHigh, double lambda, long seed){
//		
//	}
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
	
	public static UniformRandomStream getTime(double low, double high){
		Time = RandomStreams.washMachineTime(low, high, seed);
		return Time;
	}
	
	

	
	
}
