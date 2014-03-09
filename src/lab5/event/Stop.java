package lab5.event;

import lab5.state.SimState;

public class Stop {

	String exitmessage;
	String eol = System.getProperty("line.separator");

	public void execute() {

		exitmessage = "Total idle machine time: " + eol
				+ "Total queueing time: " + eol + "Mean queueing time: " + eol
				+ "Rejected cars: " + SimState.rejected;

	}
}
