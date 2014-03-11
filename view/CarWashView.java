package lab5.view;

import java.util.Observable;
import java.util.Observer;

import lab5.event.Message;
import lab5.main.Simulator;
import lab5.state.*;


public class CarWashView extends SimView implements Observer{
	int currentState;
	
	public void getCurrentState(){
		currentState = CarWashState.currentstate;
	}
	
	public void update(Observable o, Object arg) {
		boolean firstLine = true;
		if (firstLine) {
			System.out.println(firstOutput());
			firstLine = false;
			}
		if (firstLine == false){
			updateOutput(o, arg);
		}
		if (currentState == 0){ //0 = stop
			System.out.println(stopOutput(o, arg));
		}
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
				+ "Time \t" + "Fast \t" + "Slow \t" + "Id \t" + "Event \t" + "IdleTime \t"
				+ "QueueTime \t" + "QueueSize  \t" + "Rejected" + eol;
		return startMessage + afterStart;
	}
	
	public static String updateOutput(Observable o, Object arg){
		Message message = (Message) arg;
		String updateMessage = String.format("%1$.2f", message.time)+"\t" + message.mashineFast + "/t" 
				+ message.mashineSlow + "\t" + message.CarID + "\t" +
				message.currentEvent + "\t" + String.format("%1$.2f", message.idleTime) + "\t" + String.format("%1$.2f", message.queueTime) +"\t"
				+ message.queueSize + "\t" + message.rejected;
		return updateMessage;
	}

	public static String stopOutput(Observable o, Object arg){
		Message message = (Message) arg;
		String exitMessage;
		String eol = System.getProperty("line.separator");
			exitMessage = "---------------------------------------------------" +eol+"Total idle machine time: " + String.format("%1$.2f", message.idleTime) + eol
					+ "Total queueing time: " + String.format("%1$.2f", message.queueTime) + eol + "Mean queueing time: " +String.format("%1$.2f", message.queueTime/message.queued) + eol
					+ "Rejected cars: " + message.rejected;
			return exitMessage;
	}

}
