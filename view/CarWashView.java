package lab5.view;

import java.util.Observer;
import java.util.Observable;

import lab5.event.Message;
import lab5.main.Simulator;
import lab5.state.*;



public class CarWashView extends SimView implements Observer{
	int currentState;
	boolean firstLine = true;
	
	public void getCurrentState(){
		currentState = CarWashState.currentState;
	}
	public void update(Observable o, Object arg) {

		if (firstLine) {
			System.out.println(firstOutput());
			firstLine = false;
			}
		else if (firstLine == false){
			if(Message.currentEvent != "Stop"){
			System.out.println(updateOutput());
			}
			else {
				System.out.println(updateOutput());
				System.out.println(stopOutput());
				
			}
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
				+ Simulator.queueSize + eol +
				"---------------------------------------------------" + eol 
				+ "Time \t" + "Fast \t" + "Slow \t" + "Id \t" + "Event \t" + "IdleTime \t"
				+ "QueueTime \t" + "QueueSize  \t" + "Rejected" + eol;
		String upDate = updateOutput();
		return startMessage + upDate;
	}
	
	public static String updateOutput(){
		String updateMessage = String.format("%1$.2f", Message.time)+"\t" + Message.machineFast + "\t" 
				+ Message.machineSlow + "\t" + Message.CarID + "\t" +
				Message.currentEvent + "\t" + String.format("%1$.2f", Message.idleTime) + " \t\t" + String.format("%1$.2f", Message.queueTime) +"\t\t"
				+ Message.queueSize + "\t\t" + Message.rejected;
		return updateMessage;
	}
	
	public static String stopOutput(){
		String exitMessage;
		String eol = System.getProperty("line.separator");
			exitMessage = "---------------------------------------------------" + eol 
					+ "Total idle machine time: " + String.format("%1$.2f", Message.idleTime) + eol
					+ "Total queueing time: " + String.format("%1$.2f", Message.queueTime) + eol
					+ "Mean queueing time: " +String.format("%1$.2f", Message.meanQueue) 
					+ eol + "Rejected cars: " + Message.rejected;
			return exitMessage;
	}
	public String getStart(){
		return firstOutput();
	}
	public String getUpdate(){
		return updateOutput();
	} 
	public String getStop(){
		return stopOutput();
	}


}
