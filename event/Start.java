package lab5.event;

import lab5.state.CarWashState;
import lab5.state.SimState;

public class Start {

	int time;

	public void execute() {
		CarWashState.currentstate = SimState.start;
		
	}
}
