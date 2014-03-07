package lab5.view;

import java.util.Observer;
import java.util.Observable;

import lab5.state.*;


public class CarWashView implements Observer{
	int currentState;
	
	public void getCurrentState(){
		currentState = CarWashState.currentstate;
	}
	
	public String output(){
		return "";
	}

	public void update(Observable o, Object arg) {
		
		
	}

}
