package lab5.event;

import lab5.state.SimState;

public class Arrive {
	
	public void execute(){
		SimState.arrive ++;
		SimState.currentState = SimState.arrive;
	}
}
