package ncs.test1;

public class ArrayTest {

	public static void main(String[] args) {
	
		int [][] array = {{12, 41, 36, 56, 21}, {82, 10, 12, 61, 45}, {14, 16, 18, 78, 65}, {45, 26, 72, 23, 34}};

		double total = 0;
		double average = 0;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j< array[i].length; j++) {
				total += array[i][j];
				
			}
		}
		average = total / (array.length * array[0].length);
		System.out.print("합계 : ");
		System.out.printf("%.2f", total);
		System.out.println();
		System.out.print("평균 : ");
		System.out.printf("%.2f", average);
	}

}
