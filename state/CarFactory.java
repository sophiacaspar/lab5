package lab5.state;

public class CarFactory{
	public static int carId;
	
	public void carMain(){
		
	}
	
	public static Car carFactory(){
		Car car = new Car();
		car.idCar(carId);
		carId ++;
		return car;
	}
}
