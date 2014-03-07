package lab5.event;

import lab5.state.SimState;

public class SortedSequence {
	private EventQueue eventQueue;
	private SimState currentState;
	private boolean running;
	
	public SortedSequence(SimState currentState){
		this.currentState = currentState;
		eventQueue = new EventQueue();
	}
	
	public void addToQueue(Event event){
		 eventQueue.newEvent(event);	 
	}
	public void startQueue(Event event){
		addToQueue(event);
		run();
	}
	
	public void run(){
		running = true;
		while (running){
			Event e = eventQueue.sendEvent();
			e.execute(currentState, this);
		}
	}
	public void stop(){
		running = false;
	}
	//bajs
}
