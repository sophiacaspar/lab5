package lab5.state;

import lab5.event.Message;
import lab5.main.Simulator;
import lab5.random.*;
import lab5.event.Message;

public class CarWashState extends SimState{

	public static int currentstate;
	private static long seed = Simulator.seed;
	
	public static UniformRandomStream fastRandom; 
	public static UniformRandomStream slowRandom;
	public static ExponentialRandomStream exRandom;
	private static UniformRandomStream Time;
	
	public int fastCarWash, slowCarWash;
	
	public FIFO queue;
	public CarFactory factory = new CarFactory();
	
	double idleTime, queueTime, tOfLatestChange;
	public Message message;
	
	public int getState(){
		return currentstate;
	}
	
	//public CarWashState() {
	//	super();
		// TODO Auto-generated constructor stub
	//}
	public CarWashState(int queueSize, int fastMachines, int slowMachines, double fastLow, double fastHigh, double slowLow, double slowHigh, double lambda, long seed){
		queue = new FIFO(queueSize);
		this.fastCarWash = fastMachines;
		this.slowCarWash = slowMachines;
		fastRandom = new UniformRandomStream(fastLow, fastHigh, seed);
		slowRandom = new UniformRandomStream(slowLow, slowHigh, seed);
		exRandom = new ExponentialRandomStream(lambda ,seed);
	}
	
	
	public double getNextArrival(){
		return exRandom.next();
	}
	
	public double getFastWashTime(){
		return fastRandom.next();
	}
	
	public double getSlowWashTime(){
		return slowRandom.next();
	}
	
	public Car getNextCar(){
		return factory.carFactory();
	}
	
	public void addToQueue(Car car){
		queue.add(car);
	}
	
	public Car getFirstInLine(){
		return queue.first();
	}

	
	
	
	
	
	
	/**
	 * 	
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
	
	 BAAAAAAJS
	 * public void setChange(Event event, String carID){
		message.CarID = carID;

		message.idleTime = idleTime;
		message.queueTime = queueTime;
		message.queued = queueAmount;
		setChanged();
		notifyObservers(message);
	}
	
	*/

	
	
}
