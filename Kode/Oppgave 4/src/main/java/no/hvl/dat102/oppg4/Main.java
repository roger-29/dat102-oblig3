package no.hvl.dat102.oppg4;

public class Main {
	public static void main(String[] args) {
		Table<Integer> t = new Table<Integer>(20);

		t.add(5);
		t.add(4);
		t.add(7);
		t.add(32);
		t.add(1);
		t.add(50);
		t.add(72);
		t.add(54);
		t.add(34);
		t.add(12);

		Comparable[] test = t.bubbleSort();

		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}
}
