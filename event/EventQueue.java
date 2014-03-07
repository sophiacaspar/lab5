package lab5.event;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class EventQueue {
	private LinkedList<Event> eventQueue = new LinkedList<Event>();
	
	public Event sendEvent(){
    	Event first;
    	if(eventQueue.isEmpty()){
    		throw new NoSuchElementException();
    	}
    	else{
    		first = eventQueue.getFirst();
    		eventQueue.removeFirst();
    		return first;
    	}	
	}
	public void newEvent(Event event){
		if(eventQueue.isEmpty()){
			eventQueue.addFirst(event);
		}
		else{
			eventQueue.addLast(event);
		}
	}
	
}

//lolol
