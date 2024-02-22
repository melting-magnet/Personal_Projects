package ncs.test7;

public class PlaneTest {

	public static void main(String[] args) {

		Plane a = new Airplane("L747", 1000);
		Plane c = new Cargoplane("C40", 1000);
		
		System.out.println("Plane                 fuelSize");
		System.out.println("----------------------------- ");
		System.out.println(a.getPlaneName() + "                    " + a.getFuelSize());
		System.out.println(c.getPlaneName() + "                     " + c.getFuelSize());
		
		System.out.println("\n100 운항");
		((Airplane)a).flight(100);
		((Cargoplane)c).flight(100);
		System.out.println("Plane                 fuelSize");
		System.out.println("----------------------------- ");
		System.out.println(a.getPlaneName() + "                     " + a.getFuelSize());
		System.out.println(c.getPlaneName() + "                      " + c.getFuelSize());
	
		System.out.println("\n200 주유");
		a.refuel(200);
		c.refuel(200);
		System.out.println("Plane                 fuelSize");
		System.out.println("----------------------------- ");
		System.out.println(a.getPlaneName() + "                     " + a.getFuelSize());
		System.out.println(c.getPlaneName() + "                      " + c.getFuelSize());
	
	
	}

}
