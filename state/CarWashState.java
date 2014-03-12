package lab5.state;

import lab5.event.Event;
import lab5.event.Message;
import lab5.random.*;

public class CarWashState extends SimState{

	public static int currentstate;
	public static UniformRandomStream fastRandom; 
	public static UniformRandomStream slowRandom;
	public static ExponentialRandomStream exRandom;

	public int fastCarWash;
	public int slowCarWash;
	public int sizeOfQueue = 0;
	public static int rejected = 0;

	public FIFO queue;
	public CarFactory factory = new CarFactory();

	public static double idleTime, queueTime;
	public double tOfLatestChange = 0.00;

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
		if(sizeOfQueue != 0){
			double addTime = (time-tOfLatestChange);
			return queueTime += addTime;
		}
		return queueTime;
	}

	private double setIdleTime(double time) {
		if((slowCarWash + fastCarWash) != 0){
			double addTime = (time - tOfLatestChange)*(slowCarWash + fastCarWash);
			return idleTime += addTime;
		}
		return idleTime;
	}
	private double Mean(){
		if(Message.queued > 0){
			return Message.queueTime/Message.queued;
		}
		return 0.00;
	}


	public void setChange(Event event, String carID){
		Message.CarID = carID;
		Message.idleTime = idleTime;
		Message.currentEvent = event.toString();
		Message.queueTime = queueTime;
		Message.queued = sizeOfQueue;
		Message.time = tOfLatestChange;
		Message.meanQueue = Mean();
		tOfLatestChange= event.getTime();
		setChanged();
		notifyObservers();
		}

	public void setMessege(double time){
		Message.machineFast = fastCarWash;
		Message.machineSlow = slowCarWash;
		Message.queueSize = queue.size();
		Message.rejected = rejected;
		setIdleTime(time);
		setQueueTime(time);
	}
}
