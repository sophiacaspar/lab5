package lab5.event;

import lab5.state.CarWashState;
import lab5.state.SimState;

public class Stop extends Event{

	/**
	 * Adds time when to execute (quit)
	 * @param time
	 */
	public Stop(double time) {
		super(time);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(SimState simState, SortedSequence sortSeq) {
		CarWashState cwState = (CarWashState)simState;
		sortSeq.stop();
		cwState.setMessege(this.getTime());
		cwState.setChange(this, "-");
	}
}
