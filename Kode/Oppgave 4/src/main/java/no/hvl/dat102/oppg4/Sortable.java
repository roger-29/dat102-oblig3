package no.hvl.dat102.oppg4;

public interface Sortable<T> {
	public T[] bubbleSort();
	public T[] quickSort();
	public T[] mergeSort();
	public T[] radixSort();
}
