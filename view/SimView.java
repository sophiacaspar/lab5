package lab5.view;


//import java.io.PrintWriter;
import java.util.Observer;

public abstract class SimView implements Observer{
	//private static PrintWriter out;
	
	/**public static void outPutFile(){
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
	*/
}
