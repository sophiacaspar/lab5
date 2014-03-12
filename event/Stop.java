package lab5.event;

import lab5.state.CarWashState;


public class Stop extends Event{
		double time = 0.00;
		/**
	 	 * Adds time when to execute (quit)
	 	 * @param time
	 	 */
	 	public Stop(double time) {
	 		super(time);
	 		this.time = time;
	 		// TODO Auto-generated constructor stub
	 	}
	  
	 	public void execute(CarWashState cwState, SortedSequence sortSeq) {
	 		Message.currentEvent = this.toString();
	 		cwState.setMessege(time);
	 		cwState.setChange(this, "-");
	 		sortSeq.stop();
	  	}
	 	public String toString(){
			return "Stop";
		}
	 }
