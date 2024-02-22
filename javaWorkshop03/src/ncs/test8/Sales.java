package ncs.test8;

public class Sales extends Employee implements Bonus {
	
	public Sales () {
		
	}
	

	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void incentive(int pay) {
		// TODO Auto-generated method stub
		this.setSalary(pay + (int)(pay * 0.1));
	}

	@Override
	public double tax() {
		
		return getSalary()*0.13;
	}
	
	

}
