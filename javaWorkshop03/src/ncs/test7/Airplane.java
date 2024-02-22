package ncs.test7;

public class Airplane extends Plane {
	
	public Airplane() {
		
	}
	

	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void flight(int distance) {
		
		this.setFuelSize(1000 - distance * 3);
		
	}
	
	
	
	

}
