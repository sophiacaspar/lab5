package lab5.state;

import java.util.Observable;

public class SimState extends Observable{
	
	
	public final static int start=1, leave=2, stop=0; 
	public static int rejected=0, arrive=0;
	public boolean isEmpty;
	public CarWashState fast;
	public CarWashState slow;
	public static int currentState;
	
	public int getState(){
		return currentState;
	}
	
}
