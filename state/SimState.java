package lab5.state;

import java.util.Observable;

public class SimState extends Observable{
	
	public final static int start=1, leave=2, stop=0, arrive=3; 
	public static int currentState;
	
	public int getState(){
		return currentState;
	}
	
	
}


