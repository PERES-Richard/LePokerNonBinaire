package jeu;

import java.util.ArrayList;

public class CarteLaPlusHaute extends Combinaison {
	private Carte carteHaute;

	public CarteLaPlusHaute() {}

	public CarteLaPlusHaute(ArrayList<Carte> main) {
		this.carteHaute = meilleureCarte(main);
		setPuissance(1);
	}

	public Carte getCarteHaute() {
		return this.carteHaute;
	}

	public Carte meilleureCarte(ArrayList<Carte> main) {
		Carte carteH, carte;
		carteH = main.get(0);
		for (int i=1; i<main.size(); i++) {
			carte = main.get(i);
			if (carteH.getValeur() < carte.getValeur())
				carteH = carte;
		}
		return carteH;
	}

	@Override
	public int compare(ArrayList<Carte> m1, ArrayList<Carte> m2) {
		Carte c1 = meilleureCarte(m1);
		Carte c2 = meilleureCarte(m2);

		if(c1.getValeur() ==  c2.getValeur() && m1.size() > 1 && m2.size() > 1) {
			ArrayList<Carte> nm1 = new ArrayList<Carte>(m1);
			ArrayList<Carte> nm2 = new ArrayList<Carte>(m2);

			nm1.remove(c1);
			nm2.remove(c2);
			return compare(nm1,nm2);
		}
		return c1.compareTo(c2);
	}

}
