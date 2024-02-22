package ncs.test9;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ObjArrayTest {

	public static void main(String[] args) {

		Object[] array = new Object[3];
		Date[] date = new Date[3];
		

		Calendar calendar1 = new GregorianCalendar(2016, 2, 15);
		Calendar calendar2 = new GregorianCalendar(2016, 1, 25);
		Calendar calendar3 = new GregorianCalendar(2016, 0, 23);

		date[0] = calendar1.getTime();
		date[1] = calendar2.getTime();
		date[2] = calendar3.getTime();

		array[0] = new Inventory("삼성 갤럭시S7", date[0], null, 30, 0, 30);
		array[1] = new Inventory("LG G5", date[1], null, 20, 0, 20);
		array[2] = new Inventory("애플 아이패드 Pro", date[2], null, 15, 0, 15);

		for (Object obj : array) {
			System.out.println(obj.toString());

		}
		
		System.out.println();
		System.out.println("출고 수량 10 적용시 ----------------------------------------------------------");
		Date[] date2 = new Date[3];
		Calendar calendar4 = new GregorianCalendar(2016, 3, 28);
		
		for(int i = 0 ; i < array.length; i++) {
			
			date2[i] = calendar4.getTime();
			((Inventory)array[i]).setGetDate(date2[i]);
			((Inventory)array[i]).setGetAmount(10);
			((Inventory)array[i]).setInventoryAmount(((Inventory)array[i]).getPutAmount()-10);
		}
		
		for (Object obj : array) {
			System.out.println(obj.toString());

		}
		
	

	}

}
