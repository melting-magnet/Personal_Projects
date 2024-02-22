package ncs.test3;

import java.util.Scanner;

public class GoodsTest {

	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("다음 항목의 값을 입력하시오.");
		System.out.print("상품명: ");
		String name = sc.nextLine();
		System.out.print("가격: ");
		int price = sc.nextInt();
		System.out.print("수량: ");
		int quantity = sc.nextInt();
		int total = price * quantity;
		

		Goods goods = new Goods(name, price, quantity);
		
		System.out.println("입력된 결과는 다음과 같습니다.");
		System.out.println(goods.toString());
		System.out.println("총 구매 가격 : " + total + "원");
		

	}

}
