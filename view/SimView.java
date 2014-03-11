package lab5.view;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;

import lab5.state.SimState;

public class SimView extends Observable{
	protected static String State;
	private static PrintWriter out;
	
	
	public static String convertToString(int state){
		if(SimState.currentState == 0){
			State = "Stop";
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
		return State;
	}
	
	public static void outPutFile(){
		try{
			CarWashView cwView = new CarWashView();
			out = new PrintWriter(new BufferedWriter(new FileWriter("myfile.txt", true)));
				if(State == "Arrive" || State == "Leave"){
						out.println(cwView.getUpdate());
				}
				if(State == "Start"){
					out.println(cwView.getStart());
				
				}
				if(State == "Stop"){
					out.println(cwView.getStop());
				}
				out.close();
		}
		catch (IOException e){
			
		}
	}
}
