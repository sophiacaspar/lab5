package lab5.event;


import lab5.main.Simulator;
import lab5.state.Car;
import lab5.state.CarWashState;
import lab5.view.CarWashView;

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
	public void execute(CarWashState carWashState, SortedSequence sortSeq) {
		double Time = getTime();
		if(Time < Simulator.late){
		carWashState.setMessege(getTime());
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
		else{
			Stop stop = new Stop(Simulator.late);
			sortSeq.addToQueue(stop);
		}
	}
	/**
	 * 
	 * @param car
	 * @param carWashSpeed speed of car
	 * @param sortSeq
	 */
	private void addLeaveEvent(Car car, double carWashSpeed, SortedSequence sortSeq){
		Leave newLeave = new Leave(carWashSpeed+ getTime());
		CarWashView cwView= new CarWashView();
		System.out.println(cwView.getUpdate());
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

	public String toString(){
		return "Leave";
	}
}
