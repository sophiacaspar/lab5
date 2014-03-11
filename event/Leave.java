package lab5.event;

import lab5.state.Car;
import lab5.state.CarWashState;
import lab5.state.SimState;
import lab5.view.SimView;

public class Leave extends Event{
	private Car car;
	private int typeOfWash;
	/**
	 * @param time
	 */
	public Leave(double time) {
		super(time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(SimState simState, SortedSequence sortSeq) {
		CarWashState carWashState = (CarWashState)simState;
		
		carWashState.setMessege(this.getTime());
		if(typeOfWash == 0){
			Car newCar = carWashState.getFirstInLine();
			
			if(newCar == null){
				carWashState.fastCarWash++;
			}
			else {
				addLeaveEvent(newCar, carWashState.getFastWashTime(), sortSeq);
			}
		}
		else{
			Car newCar = carWashState.getFirstInLine();
			if(newCar == null){
				carWashState.slowCarWash++;
			}
			else {
				addLeaveEvent(newCar, carWashState.getSlowWashTime(), sortSeq);
			}
		}
		carWashState.setChange(this, car.getId()+"");
	}
	/**
	 * 
	 * @param car
	 * @param carWashSpeed speed of car
	 * @param sortSeq
	 */
	private void addLeaveEvent(Car car, double carWashSpeed, SortedSequence sortSeq){
		Leave newLeave = new Leave(carWashSpeed+this.getTime());
		newLeave.setCar(car);
		sortSeq.addToQueue(newLeave);
	}
	
	
	/**
	 * Set the car that leaves.
	 * @param car the car that is added.
	 */
	
	public void setCar(Car car){
		this.car = car;
	}
	/**
	 * Set what carWash the object came from.
	 * @param typeOf 0 is fast wash 1 is slow.
	 * 
	 */
	public void setCarWash(int typeOf){
		typeOfWash = typeOf;
	}
	
	public String getState(){
		int currentstate = 2; //2 = leave
		return SimView.convertToString(currentstate);
	}
}