package lab5.state;

import lab5.random.*;

public class RandomStreams{
	static UniformRandomStream s;
	static ExponentialRandomStream m;
	
	public static UniformRandomStream washMachineTime(double high, double lower, long seed){
		s = new UniformRandomStream(high,lower,seed);
		return s;
	}
	public static ExponentialRandomStream simTime(double high, long seed){
		m = new ExponentialRandomStream(high, seed);
		return m;
	}
}


