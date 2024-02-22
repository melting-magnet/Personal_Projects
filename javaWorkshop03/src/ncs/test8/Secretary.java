package ncs.test8;

public class Secretary extends Employee implements Bonus{

	public Secretary() {
		
	}
	
	
	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void incentive(int pay) {

		this.setSalary(pay + (int)(pay * 0.1));
		
	}

	@Override
	public double tax() {
		// TODO Auto-generated method stub
		return getSalary()*0.1;
	}

}
