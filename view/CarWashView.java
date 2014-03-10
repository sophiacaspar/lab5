package lab5.view;

import java.util.Observer;
import java.util.Observable;

import lab5.event.Event;
import lab5.main.Simulator;
import lab5.state.*;


public class CarWashView extends SimView implements Observer{
	int currentState;
	
	public void getCurrentState(){
		currentState = CarWashState.currentstate;
	}
	
	public static String firstOutput(){
		String startMessage;
		String eol = System.getProperty("line.separator");
		startMessage = "Fast machines: " + Simulator.fastMachines + eol
				+ "Slow machines: " + Simulator.slowMachines + eol
				+ "Fast distribution: (" + Simulator.fastLow + ", "
				+ Simulator.fastHigh + ")" + eol + "Slow distribution: ("
				+ Simulator.slowLow + ", " + Simulator.slowHigh + ")" + eol
				+ "Exponential distribution with lambda = " + Simulator.lambda
				+ eol + "Seed: " + Simulator.seed + eol + "Max Queue size: "
				+ Simulator.queueSize + eol;
		String afterStart = "---------------------------------------------------" + eol 
				+ "Time /t" + "Fast /t" + "Slow /t" + "Id /t" + "Event /t" + "IdleTime /t"
				+ "QueueTime /t" + "QueueSize  /t" + "Rejected" + eol;
		return startMessage + afterStart;
	}
	
	public static String updateOutput(){
		String updateMessage = Event.getTime()+"/t" + CarWashState.fastCarWash + "/t" 
				+ CarWashState.slowCarWash + "/t" + CarFactory.carId + "/t" +
				State + "/t" + CarWashState.idleTime + "/t" + CarWashState.queueTime +"/t"
				+ CarWashState.sizeOfQueue + "/t" + CarWashState.rejected;
		return updateMessage;
	}
	
	public static String stopOutput(){
		String exitMessage;
		String eol = System.getProperty("line.separator");
			exitMessage = "Total idle machine time: " + eol
					+ "Total queueing time: " + eol + "Mean queueing time: " + eol
					+ "Rejected cars: " + CarWashState.rejected;
			return exitMessage;
	}

	public void update(Observable o, Object arg) {
		boolean firstLine = true;
		if (firstLine) {
			System.out.println(firstOutput());
			firstLine = false;
			}
		else{
			updateOutput();
		}
		if (currentState == 0){ //0 = stop
			System.out.println(stopOutput());
		}
	}

}
