package no.hvl.dat102.oppg4;

public class Table<T extends Comparable<T>> implements Sortable<T> {

	private T[] table;
	private int length;

	public Table(int n) {
		table = ((T[]) new Comparable[1000]);
	}

	public void add(T s) {
		table[length] = s;
		length++;
	}

	public void expand() {
		T[] t = ((T[]) new Comparable[table.length * 2]);

		for (int i = 0; i < table.length; i++) {
			t[i] = table[i];
		}
	}

	// Sorteringsmetoder

	public T[] bubbleSort() {
		T[] arr = ((T[]) new Comparable[length]);

		for (int i = 0; i < length; i++) {
			arr[i] = table[i];
		}

		T temp;
		for (int i = 0; i < length; i++) {
			for (int j = 1; j < (length - i); j++) {
				if (arr[j - 1].compareTo(arr[j]) > 0) { 
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;
	}

	public T[] quickSort() {
		T[] arr = ((T[]) new Comparable[length]);
		return arr;
	}

	public T[] mergeSort() {
		T[] arr = ((T[]) new Comparable[length]);
		return arr;
	}

	public T[] radixSort() {
		T[] arr = ((T[]) new Object[length]);
		return arr;
	}
}
