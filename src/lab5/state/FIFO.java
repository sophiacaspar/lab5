package lab5.state;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class FIFO {
		
		private static ArrayList<Object> queue = new ArrayList<Object>();
		private static int maxSize = CarWashState.max;
		
		/*
		 * adds an item to the Queue
		 * 
		 * @see Queue#add(java.lang.Object)
		 */
	    public static void add(Object item){
	        	if(queue.size()< maxSize){
	        		queue.add(item);
	        	}
	        	else{
	        		SimState.rejected ++;
	        	}
	    }
	    /*
	     * Checks if the queue is empty 
	     * @see Queue#removeFirst()
	     */
	    public void firstInLine() throws NoSuchElementException{
	    	if(queue.isEmpty()){
	    		throw new NoSuchElementException();
	    	}
	    	queue.remove(0);
	    }
	    
	    /*
	     * Checks if the Queue is Empty otherwise it returns the first element in the queue.
	     * 
	     * @see Queue#first()
	     */
	   
	    public Object first() throws NoSuchElementException{
	    	Object first;
	    	if(isEmpty()){
	    		throw new NoSuchElementException();
	    	}
	    	first = queue.get(0);
	    	firstInLine();
	    	return first;
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
