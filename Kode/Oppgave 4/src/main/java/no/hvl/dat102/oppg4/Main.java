package no.hvl.dat102.oppg4;

public class Main {

	public static void sortTest(Comparable[] testArr, String algoritme) {
		System.out.println("\nTest av " + algoritme);

		for (int i = 0; i < testArr.length; i++) {
			System.out.println(testArr[i]);
		}
	}

	public static void main(String[] args) {
		Table<Integer> t = new Table<Integer>(20);

		// Legger til elementer i tabell for sortering
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

		// Test av sorteringsmetoder
		sortTest(t.insertionSort(), "sortering ved innsetting");
		sortTest(t.selectionSort(), "sortering ved utvalg");
		sortTest(t.bubbleSort(), "boblesortering");
		sortTest(t.quickSort(), "quick-sort");
		sortTest(t.mergeSort(), "flettesortering");
		sortTest(t.radixSort(), "radix-sortering");
	}
}
