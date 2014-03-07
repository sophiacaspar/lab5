package lab5.state;

import lab5.event.Message;
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
	public Message message;
	
	public int getState(){
		return currentstate;
	}
	
	public CarWashState() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public CarWashState(int queueSize, int fastMachines, int slowMachines, double fastLow, double fastHigh, double slowLow, double slowHigh, double lambda, long seed){
//		
//	}
	public static void fast(int fastMachines, double fastLow, double fastHigh){
		fastRandom = getTime(fastLow, fastHigh);
		fastMachines --;
	}
	public static void slow(int slowMachines, double slowLow, double slowHigh){
		slowRandom = getTime(slowLow, slowHigh);
		slowMachines --;
	}
	
	public static UniformRandomStream getTime(double low, double high){
		Time = RandomStreams.washMachineTime(low, high, seed);
		return Time;
	}
	
	public void setChange(Event event, String carID){
		message.CarID = carID;
		message.currentEvent = event.toString();
		message.time = event.getTime();
		message.idleTime = idleTime;
		message.queueTime = queueTime;
		message.queued = queueAmount;
		setChanged();
		notifyObservers(message);
	}
	
	

	
	
}
