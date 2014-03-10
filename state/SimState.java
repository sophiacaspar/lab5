package lab5.state;

import java.util.Observable;

import lab5.event.Message;
import lab5.main.Simulator;
import lab5.state.CarFactory;

public class SimState extends Observable{
	
	
	public final static int start=1, leave=2, stop=0, arrive=3; 
	public static int numberSlow =Simulator.fastMachines, numberFast=Simulator.slowMachines; 
	public boolean isEmpty;	
	public CarWashState fast;
	public CarWashState slow;
	public static int currentState;
	
	public int getState(){
		return currentState;
	}
	
	public static int emptyMachines(){
		return (numberSlow + numberFast);
	}

	 public SimState(){
	 
		CarWashState machine = fast;

		if(machine == fast){
			if(numberFast != 0){
				numberFast --;
			}
			else{
				machine = slow;
			}
		}
		if (machine == slow){
			if(numberSlow != 0){
				numberSlow --;
			}
			else{
				FIFO.add(CarFactory.carFactory());
			}
		}	
}

}

