package ncs.test8;

public class Company {

	public static void main(String[] args) {
		Employee[] employees = new Employee[2]; 
		
		employees[0] = new Secretary("Hilery", 1, "secretary", 800);
		employees[1] = new Sales("Clinten", 2, "sales", 1200);
		
		System.out.println("name        department        salary");
		System.out.println("------------------------------------");
		for(int i = 0 ; i < employees.length; i++) {
			System.out.println(employees[i].getName() + "        " + employees[i].getDepartment() + "        " + employees[i].getSalary());
		
		}
		
		System.out.println("\n인센티브 100 지급");
		System.out.println("name        department        salary       tax");
		System.out.println("----------------------------------------------");
		((Secretary)(employees[0])).incentive(800);
		((Sales)(employees[1])).incentive(1200);
		((Secretary)(employees[0])).tax();
		((Sales)(employees[1])).tax();
		
		for (int i = 0; i < employees.length; i++) {
		    System.out.print(employees[i].getName() + "        " + employees[i].getDepartment() + "        " + employees[i].getSalary());
		    
		    if (employees[i] instanceof Secretary) {
		        System.out.print("        " + employees[i].tax()+"\n");
		        // Add any Secretary specific information or behavior here
		    } else if (employees[i] instanceof Sales) {
		        System.out.print("         " + employees[i].tax()+"\n");
		        // Add any Sales specific information or behavior here
		    } else {
		        System.out.println();
		        
		    }
		}
		

	}

}
