package lab5.event;

import java.util.Observable;

import lab5.state.SimState;

public abstract class Event extends Observable {
	private static double time;
	
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
	public abstract void execute(SimState simState, SortedSequence sortSeq);
	/**
	 * 
	 * @return time when event happens
	 */
	public static double getTime(){
		return time;
	}
}

