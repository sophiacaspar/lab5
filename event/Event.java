package lab5.event;

import java.util.Observable;

import lab5.state.CarWashState;
import lab5.state.SimState;

public abstract class Event extends Observable {
	private double time;
	
	/**
	 * @param time
	 *  creates time that the event class can use.
	 */
	public Event(double time){
		this.time = time;
	}
	/**
	 * Called when the event happens. 
	 * @param simState current state of the simulator.
	 * @param sortSeq, SortedSequence that executes the event.
	 */
	public abstract void execute(CarWashState carWashState, SortedSequence sortSeq) ;
	// TODO Auto-generated method stub
	/**
	 * 
	 * @return time when event happens
	 */
	public double getTime(){
		return time;
	}

}

