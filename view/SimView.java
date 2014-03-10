package lab5.view;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Oberverable;

import lab5.state.SimState;

public class SimView extends Oberservable{
	protected String State;
	
	
	public void convertToString(int state){
		if(SimState.currentState == 0){
			State = "Stop";
			outPutFile();
			setChanged();
			notifyObersvers();
		}
		if(SimState.currentState == 1){
			State = "Start";
		}
		if(SimState.currentState == 2){
			State = "Leave";
		}
		if(SimState.currentState == 3){
			State = "Arrive";
		}
	}
	
	public void outPutFile(){
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.txt", true)));
				if(SimState.currentState == 2 || SimState.currentState == 3){
					if(SimState.currentState == 2){
						out.println();
					}
					out.println();
				}
			
		}
	}
}
