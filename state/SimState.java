package lab5.state;

import java.util.Observable;

import lab5.main.Simulator;
import lab5.state.CarFactory;

public class SimState extends Observable{
	
	
	public final static int start=1, leave=2, stop=0; 
	public static int rejected=0, arrive=0, number =0, numbers=0;
	public boolean isEmpty;
	public CarWashState fast;
	public CarWashState slow;
	public static int currentState;
	
	public int getState(){
		return currentState;
	}
	public SimState(){
		CarWashState machine = fast;
		if(machine == fast){
			if(number != Simulator.fastMachines){
				CarWashState.fast(Simulator.fastMachines, Simulator.fastHigh, Simulator.fastLow);
				number ++;
			}
			else{
				machine = slow;
			}
		}
		if (machine == slow){
			if(numbers != Simulator.slowMachines){
				CarWashState.slow(Simulator.slowMachines, Simulator.slowHigh, Simulator.slowLow);
				numbers ++;
			}
			else{
				FIFO.add(CarFactory.carId);
			}
		}
		
	}
	
}
