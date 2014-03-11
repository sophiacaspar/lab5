package lab5.event;

import lab5.state.CarWashState;
import lab5.state.SimState;
import lab5.view.CarWashView;

public class Start extends Event{

	/** 
	 * Adds time when to execute
	 * @param time
	 */
	public Start(double time) {
		super(time);
	}

	@Override
	public void execute(SimState simState, SortedSequence sortSeq) {
		CarWashState cwState = (CarWashState)simState;
		Arrive newArrive = new Arrive(cwState.getNextArrival());
		newArrive.setCar(cwState.getNextCar());
		sortSeq.addToQueue(newArrive);
		cwState.setMessege(this.getTime());
		cwState.setChange(this, "-");
		
	}
	public String toString(){
		return "Start";
	}
	
	/**public String getState(){
		int currentstate = 1; //1 = start
		return CarWashView.convertToString(currentstate);
	}*/
}