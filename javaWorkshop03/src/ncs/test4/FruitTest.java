package ncs.test4;

public class FruitTest {

	public Fruit[] initFruit(int i) {

		Fruit[] fruit = new Fruit[i];

		fruit[0] = new Fruit("apple", 1200, 3);
		fruit[1] = new Fruit("banana", 2500, 2);
		fruit[2] = new Fruit("grape", 4500, 5);
		fruit[3] = new Fruit("orange", 800, 10);
		fruit[4] = new Fruit("melon", 5000, 2);

		return fruit;
	}

	public void printFruit(Fruit[] fruit) {

		for (int i = 0; i < fruit.length; i++) {
			System.out.println(fruit[i].toString());
		}
	}

	public static void main(String[] args) {

		FruitTest f = new FruitTest();

		Fruit[] a = f.initFruit(5);
		f.printFruit(a);

	}

}
