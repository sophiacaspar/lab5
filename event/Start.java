package lab5.event;

import lab5.main.Simulator;
import lab5.state.CarWashState;
import lab5.state.SimState;

public class Start {

	int time;
	String startmessage = "";
	String eol = System.getProperty("line.separator");

	public void execute() {
		CarWashState.currentstate = SimState.start;

		startmessage = "Fast machines: " + Simulator.fastMachines + eol
				+ "Slow machines: " + Simulator.slowMachines + eol
				+ "Fast distribution: (" + Simulator.fastLow + ", "
				+ Simulator.fastHigh + ")" + eol + "Slow distribution: ("
				+ Simulator.slowLow + ", " + Simulator.slowHigh + ")" + eol
				+ "Exponential distribution with lambda = " + Simulator.lambda
				+ eol + "Seed: " + Simulator.seed + eol + "Max Queue size: "
				+ Simulator.queueSize;
	}
}
