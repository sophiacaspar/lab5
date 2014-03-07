package lab5.view;

import java.util.Observer;
import java.util.Observable;

import lab5.state.*;


public class CarWashView implements Observer{
	int currentState;
	
	public void getCurrentState(){
		currentState = CarWashState.currentstate;
	}
	
	public void firstOutput(){
		System.out.println("-----------------------------------------------------");
		System.out.println("Time" + "\t" + "Fast" + "\t"
				+ "Slow" + "\t" + "ID" + "\t" + "Event" + "\t"
				+ "IdleTime" + "\t" + "QueueTime" + "\t" + "QueueSize"
				+ "\t" + "Rejected");
	}
	
	public void updateOutput(){
		
	}

	public void update(Observable o, Object arg) {
		boolean firstLine = true;
		if (firstLine) {
			firstOutput();
			firstLine = false;
			}
		
	}

}
