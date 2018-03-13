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
		long t_1, t_2;
		
		t_1 = System.nanoTime();

		p.solve();
		
		t_2 = System.nanoTime();

		return t_2 - t_1;
	}

	public static void main(String[] args) {

		System.out.println("\n===== Oppgave 1a =====\n");
		System.out.println("Summen av de 100 første naturlige heltallene:");
		System.out.println(sum(100) + "\n");
		
		System.out.println("\n===== Oppgave 1b =====\n");
		System.out.println("Tallrekken a, fra a_0 til a_9:");
		for (int i = 0; i < 10; i++) {
			System.out.print(a(i) + " ");
		}
		System.out.println("\n");

		System.out.println("\n===== Oppgave 1c =====\n");
		System.out.println(String.format("16 ringer: %8s µs", measureHanoiTime(16) / 1000));
		System.out.println(String.format("24 ringer: %8s µs", measureHanoiTime(24) / 1000));
		System.out.println(String.format("32 ringer: %8s µs", measureHanoiTime(32) / 1000));

		System.out.println();
	}
}
