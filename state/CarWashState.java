package lab5.state;

import lab5.event.Event;
import lab5.event.Message;
import lab5.main.Simulator;
import lab5.random.*;
import lab5.view.SimView;

public class CarWashState extends SimState{

	public static int currentstate;
	private static long seed = Simulator.seed;
	
	public static UniformRandomStream fastRandom; 
	public static UniformRandomStream slowRandom;
	public static ExponentialRandomStream exRandom;
	
	public static int fastCarWash, slowCarWash;
	public static int sizeOfQueue = 0;
	public static int rejected = 0;
	
	public FIFO queue;
	public CarFactory factory = new CarFactory();
	
	public static double idleTime, queueTime, tOfLatestChange;
	public Message message;
	
	public int getState(){
		SimView.convertToString(currentstate);// where should we put it ??? / I just lay it here. 
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
		return CarFactory.carFactory();
	}
	
	public boolean addToQueue(Car car){
		return FIFO.add(car);
	}
	
	public Car getFirstInLine(){
		return (Car) queue.first();
	}
	
	private double setQueueTime(double time) {
		double addTime = (time-this.tOfLatestChange);
		return queueTime += addTime;
	}
	
	private double setIdleTime(double time) {
		double addTime = (time-this.tOfLatestChange)*(slowCarWash + fastCarWash);
		return idleTime += addTime;
	}
		
		
	public void setChange(Event event, String carID){
		message.CarID = carID;
		message.idleTime = idleTime;
		message.queueTime = queueTime;
		message.queued = sizeOfQueue;
		message.time = tOfLatestChange;
		tOfLatestChange= event.getTime();
		setChanged();
		notifyObservers(message);
		}
	
	public void setMessege(double time){
		message = new Message();
		message.mashineFast = fastCarWash;
		message.mashineSlow = slowCarWash;
		message.queueSize = queue.size();
		message.rejected = SimState.rejected;
		setIdleTime(time);
		setQueueTime(time);
	}
}
