package no.hvl.dat102.oppg2.klient;

import no.hvl.dat102.oppg2.dobbelkjedetordnetlistem.DobbelKjedetOrdnetListeM;

public class KlientDobbelKjedetOrdnetListeM {

	public static void main(String[] args) {

		String[] ord = { "o", "a", "s", "m", "e", "k", "c" };

		DobbelKjedetOrdnetListeM<String> liste = new DobbelKjedetOrdnetListeM(new String("AAA"), new String("zzz"));

		// Legger data inn i listen
		for (int i = 0; i < ord.length; i++)
			liste.leggTil(ord[i]);

		// Skriver ut liste
		System.out.println("\n\nOpprinnelig liste");
		liste.skrivListe();

		// Tester om et bestem element fins
		String element = new String("a");

		boolean funnet = liste.fins(element);
		if (funnet)
			System.out.println("\nElementet " + element + " fins\n");
		else
			System.out.println("\nElementet " + element + " fins ikke\n");

		// Fjerner noen fra listen og skriver ut igjen
		String[] elementer = new String[7];

		elementer[0] = new String("a");
		elementer[1] = new String("m");
		elementer[2] = new String("e");
		elementer[3] = new String("o");
		elementer[4] = new String("k");
		elementer[5] = new String("c");
		elementer[6] = new String("s");

		for (int i = 0; i < elementer.length; i++) {
			System.out.println("Fjerner " + elementer[i]);
			liste.fjern(elementer[i]);
			liste.skrivListe();
		}
	}
}
