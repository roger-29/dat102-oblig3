package no.hvl.dat102.oppg2.dobbelkjedetordnetlistem;

import no.hvl.dat102.oppg2.adt.DobbelKjedetOrdnetListeMADT;
 
// Representerer en dobbeltkjedet ordnet liste med midtpeker.

public class DobbelKjedetOrdnetListeM<T extends Comparable<T>> implements DobbelKjedetOrdnetListeMADT<T> {

	private DobbelNode<T> foerste;
	private DobbelNode<T> midten;
	private DobbelNode<T> siste;
	private int antall;

	/******************************************************************
	 * Oppretter en tom liste.
	 ******************************************************************/
	// Konstruktør

	public DobbelKjedetOrdnetListeM(T minVerdi, T maksVerdi) {

		// Første node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		foerste = nyNode1;
		midten = foerste;

		// Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>(maksVerdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;

		antall = 0;
	}

	@Override
	public void leggTil(T el) {

		// Setter inn ordnet før den noden p peker på
		DobbelNode<T> p;

		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());
			return;
		}

		// Kun lovlige verdier

		if (el.compareTo(midten.getElement()) >= 0) { // Finn plass i siste halvdel
			p = midten.getNeste();
			// midten = midten.getForrige()
		} else { // Finn plass i første halvdel
			p = foerste.getNeste();
			// midten = midten.getNeste()
		}

		while (el.compareTo(p.getElement()) >= 0) {
			p = p.getNeste();
		}

		// Setter inn:
		// Innsett foran noden som p peker på
		DobbelNode<T> neste = p;
		DobbelNode<T> forrige = p.getForrige();

		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		nyNode.setForrige(forrige);
		nyNode.setNeste(neste);

		forrige.setNeste(nyNode);
		neste.setForrige(nyNode);

		// Oppdaterer ny midten og inkrementerer antall
		nyMidten();
		antall++;
	}

	// **********************************************************************************
	// Hjelpemetode til å finne ny midten.
	// Mindre effektiv fordi vi må gjennomgå ca halve listen, men greit nok,
	// ellers kan en teste på om antall er partall er oddetall ved oppdatering
	// av midtpeker
	// *********************************************************************************
	private void nyMidten() {
		int n = antall / 2;
		DobbelNode<T> p = foerste.getNeste();
		for (int i = 1; i <= n; i++) {
			p = p.getNeste();
		}
		midten = p;
	}

	@Override
	public boolean fins(T el) {
		return finn(el) != null ? true : false;
	}

	@Override
	public T fjern(T el) {
		DobbelNode<T> p = finn(el);

		if (p == null) return null;

		DobbelNode<T> forrige = p.getForrige();
		DobbelNode<T> neste = p.getNeste();

		forrige.setNeste(neste);
		neste.setForrige(forrige);

		antall--;
		nyMidten();

		return p.getElement();
	}

	private DobbelNode<T> finn(T el) {
		DobbelNode<T> node = null;
		DobbelNode<T> p = null;

		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());
		}

		// Kun lovlige verdier
		if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
			p = midten; // Midten defineres å tilhøre siste del
		} else { // Let i første halvdel
			p = foerste.getNeste();
		}
		while (el.compareTo(p.getElement()) > 0) {
			p = p.getNeste();
		} // while

		// Test på funnet
		if (el.compareTo(p.getElement()) == 0) {
			node = p;
		}
		return node;
	}

	public void skrivListe() {
		DobbelNode<T> p = foerste;

		while (p != null) {
			System.out.print(p.getElement() + " ");
			p = p.getNeste();
		}

		System.out.println();
		System.out.println("Foerste:" + foerste.getElement());
		System.out.println("Midten:" + midten.getElement());
		System.out.println("Siste:" + siste.getElement());
		System.out.println();
	}
}
