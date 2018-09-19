package jeu;

import java.util.ArrayList;

public class CarteLaPlusHaute extends Combinaison {
	private Carte carteHaute;

	public CarteLaPlusHaute(ArrayList<Carte> main) {
		Carte carteH, carte;
		carteH = main.get(0);
		for (int i=1; i<main.size(); i++) {
			carte = main.get(i);
			if (carteH.getValeur() < carte.getValeur())
				carteH = carte;
		}
		this.carteHaute = carteH;
	}

	public Carte getCarteHaute() {
		return this.carteHaute;
	}

	/*
	public int compare(ArrayList<Carte> m1, ArrayList<Carte> m2) {
		int maxm1=0; int i1=0; int i2=0; int maxm2=0;
		for(Carte c : m1) {
			if (maxm1 < c.getValeur()) { maxm1 = c.getValeur(); i1 = m1.indexOf(c);}
		}
		for(Carte c2 : m2) {
			if (maxm2 < c2.getValeur()) { maxm2 = c2.getValeur(); i2=m1.indexOf(c2);}
		}
		if(maxm2 == maxm1) {
			m1.remove(i1);
			m2.remove(i2);
			compare(m1,m2);
		}
		if (maxm2 > maxm1)
			return maxm2;
		else
			return maxm1;
	}
	*/
}
