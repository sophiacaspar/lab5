package lab5.event;

import lab5.state.CarWashState;

public class Start {
	int time;
	public void execute(){
		CarWashState.currentstate = start;
	}
}
