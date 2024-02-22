package product.run;

import product.view.ProductView;

public class ProductRun {
	
	public static void main (String[] args) {
		
		ProductView pv = new ProductView();
		
		pv.displayMenu();
		System.out.println("시스템을 종료합니다.");
	}

}
