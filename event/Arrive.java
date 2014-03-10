package lab5.event;

import lab5.state.Car;
import lab5.state.CarWashState;
import lab5.state.SimState;

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
	public void execute(SimState simState, SortedSequence sortSeq) {
		CarWashState cwState = (CarWashState)simState;
		cwState.setMessege(getTime());
		
		addNextArrive(cwState, sortSeq);
		if (cwState.fastCarWash!=0) {
			cwState.fastCarWash--;
			addLeaveEvent(car, fastWashID, cwState.getFastWashTime(), sortSeq);
		}
		else if (cwState.slowCarWash!=0) {
			cwState.slowCarWash--;
			addLeaveEvent(car, slowWashID, cwState.getSlowWashTime(), sortSeq);
		} 
		else {
			if(cwState.addToQueue(car)){
				carWashState.sizeOfQueue++;
			}else{
				carWashState.rejected++;
			}
			
		}
		cwState.setChange(this, car.getId()+"");
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
	private void addNextArrive(CarWashState cwState, SortedSequence sortSeq){
		double d = cwState.getNextArrival();
		Arrive newEvent = new Arrive(d+getTime());
		newEvent.setCar(cwState.getNextCar());
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
}
