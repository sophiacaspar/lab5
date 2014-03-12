package lab5.event;

import lab5.main.Simulator;
import lab5.state.Car;
import lab5.state.CarWashState;


public class Arrive extends Event{
	private Car car;// Arriving car
	private static final int fastWashID = 0;
	private static final int slowWashID = 1;

	/**
	 * @param time
	 * 
	 */

	public Arrive(double time) {
		super(time);
	}
	/**
	 * Executes arrive event.
	 */
	@Override
	public void execute(CarWashState carWashState, SortedSequence sortSeq) {
		double Time = getTime();
		if(Time < Simulator.late){
		addNextArrive(carWashState, sortSeq);
		carWashState.setMessege(Time);
		if (carWashState.fastCarWash!=0) {
			carWashState.fastCarWash--;
			addLeaveEvent(car, fastWashID, carWashState.getFastWashTime(), sortSeq);
		}
		else if (carWashState.slowCarWash!=0) {
			carWashState.slowCarWash--;
			addLeaveEvent(car, slowWashID, carWashState.getSlowWashTime(), sortSeq);
		} 
		else {
			if(carWashState.addToQueue(car)){
				carWashState.sizeOfQueue++;
			}
			else{
				CarWashState.rejected++;
			}
		}
		carWashState.setChange(this, car.getId()+"");
		}
		else{
			Stop stop = new Stop(Simulator.late);
			sortSeq.addToQueue(stop);
		}
		
	}

	private void addLeaveEvent(Car car,int carWashType, double carWashSpeed, SortedSequence sortSeq){
		Leave newLeave = new Leave(carWashSpeed+getTime());
		newLeave.setCar(car);
		newLeave.setCarWash(carWashType);
		sortSeq.addToQueue(newLeave);
	}
	/**
	 * Adds next arrive object to the event queue
	 * @param simState the CarWashState
	 * @param sortSeq SortedSequence
	 */
	private void addNextArrive(CarWashState carWashState, SortedSequence sortSeq){
		double d = carWashState.getNextArrival();
		Arrive newEvent = new Arrive(d+getTime());
		newEvent.setCar(carWashState.getNextCar());
		sortSeq.addToQueue(newEvent);
	}

	/**Set the the car that arrives.
	 * @param car
	 */
	public void setCar(Car car){
		this.car = car;
	}
	/** Returns car
	 * @return car
	 */
	public Car getCar(){
		return this.car;
	}

	public String toString(){
		return "Arrive";
	}
}
