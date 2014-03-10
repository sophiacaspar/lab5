package lab5.state;

public class CarFactory{
	int carId;
	
	public void carMain(){
		
	}
	
	public Car carFactory(){
		Car car = new Car();
		car.idCar(carId);
		carId ++;
		return car;
	}
	
}
