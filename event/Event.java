package lab5.event;

import java.util.Observable;

import lab5.state.CarWashState;


public abstract class Event extends Observable {
	private static double times= 0.00;

	/**
	 * @param time
	 *  creates time that the event class can use.
	 */
	public Event(double time){
		times = time;
	}
	/**
	 * Called when the event happens. 
	 * @param carWashState current state of the simulator.
	 * @param sortSeq, SortedSequence that executes the event.
	 */
	public abstract void execute(CarWashState simState, SortedSequence sortSeq);
	/**
	 * 
	 * @return time when event happens
	 */
	public double getTime(){
		return times;
	}
	public static double getsTime(){
		return times;
	}

}
