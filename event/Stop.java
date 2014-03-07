package lab5.event;

import lab5.state.CarWashState;
import lab5.state.SimState;

public class Stop {

	public void execute() {
		CarWashState.currentstate = SimState.stop;

	}
}
