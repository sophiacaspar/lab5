package lab5.event;


import lab5.state.CarWashState;

public class Start extends Event{

	/** 
	 * Adds time when to execute
	 * @param time
	 */
	static double nextTime = 0.00;
	static double Time = 0.00;
	public Start(double time) {
		super(time);
		
	}

	@Override
	public void execute(CarWashState cwState, SortedSequence sortSeq) {
		Arrive newArrive = new Arrive(cwState.getNextArrival());
		newArrive.setCar(cwState.getNextCar());
		sortSeq.addToQueue(newArrive);
		cwState.setMessege(Time);
		nextTime = getTime();
		cwState.setChange(this, "-");
		Time = nextTime;

	}
	public String toString(){
		return "Start";
	}

		
	}

