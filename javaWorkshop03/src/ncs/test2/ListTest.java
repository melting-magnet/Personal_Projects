package ncs.test2;

import java.util.Random;

public class ListTest {

	Random r = new Random();

	public void init(int[] array) {

		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1, 101);
		}

	}

	public void display(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public void sort(int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		
		int[] array = new int[10];
		
		ListTest l = new ListTest();
		
		l.init(array);
		l.display(array);
		l.sort(array);
		System.out.println();
		l.display(array);

	}

}
