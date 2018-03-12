package no.hvl.dat102.oppg1;

public class Main {
	
	public static int sum(int n) {
		return n == 1 ? 1 : sum(n - 1) + n;
	}

	public static int a(int n) {
		if (n == 0) return 2;
		if (n == 1) return 5;

		return 5 * a(n - 1) - 6 * a(n - 2) + 2;
	}

	public static int hanoi(int n) {
		if (n == 1) return 1;

		return 2 * a(n - 1) + 1;
	}

	public static long measureHanoiTime(int n) {
		TowersOfHanoi p = new TowersOfHanoi(n);

		long t_1 = System.nanoTime();

		long moves = p.solve();
		System.out.println("Moves: " + moves);

		long t_2 = System.nanoTime();

		return t_2 - t_1;

	}

	public static void main(String[] args) {
		/*System.out.println(sumRecursive(100) + "\n");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(a(i));
		}*/

		System.out.println(measureHanoiTime(28) / 1000000);
		System.out.println(measureHanoiTime(30) / 1000000);
		System.out.println(measureHanoiTime(32) / 1000000);
	}
}
