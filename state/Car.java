package lab5.state;

public class Car extends CarFactory {
	private int id=0;
	
	public int idCar(int id){
		this.id = id;
		return this.id;
	}
	
	public int getId(){
		return id;
	}
}
