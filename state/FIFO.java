package lab5.state;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import lab5.main.Simulator;


public class FIFO {
		
		private static ArrayList<Object> queue = new ArrayList<Object>();
		private static int maxSize;
		
		public FIFO(int max){
			maxSize = Simulator.queueSize;
		}
		/*
		 * adds an item to the Queue
		 * 
		 * @see Queue#add(java.lang.Object)
		 */
	    public static boolean add(Object item){
	        	if(queue.size() < maxSize){
	        		queue.add(item);
	        		return true;
	        	}
	        	else{
	        		return false;
	        	}
	    }
	    /*
	     * Checks if the queue is empty 
	     * @see Queue#removeFirst()
	     */
	    public void firstInLine(){
	    	if(queue.isEmpty()){
	    		throw new NoSuchElementException();
	    	}
	    	CarWashState.rejected++;
	    	queue.remove(0);
	    }
	    
	    /*
	     * Checks if the Queue is Empty otherwise it returns the first element in the queue.
	     * 
	     * @see Queue#first()
	     */
	   
	    public Object first(){ //throws NoSuchElementException{
	    	Object first;
	    	if(queue.isEmpty()){
	    		return null;
	    	}
	    	else{
	    	first = queue.get(0);
	    	firstInLine();
	    	return first;
	    	}
	    }
	    
	     /*
	      * Check if the Queue is Empty.
	      * 
	      * @see Queue#isEmpty()
	      */
	    
	    public boolean isEmpty(){
	        	if(queue.size() == 0){
	        		return true;
	        	}
	        	return false;
	    }
	    
	    /*
	     * returns the size of Queue
	     * 
	     * @see Queue#size()
	     */
	    
	    public int size(){
	    	return queue.size();
	    }
	    
	
}

