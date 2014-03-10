package lab5.event;

import java.util.Observable;

import lab5.state.SimState;

public class Event extends Observable {
	private double time;
	
	public void execute(SimState simState, SortedSequence sortSeq){
		
	}
	public Event(double time){
		this.time = time;
	}
	
	public double getTime(){
		return time;
	}
}
