package jeu;

import java.util.ArrayList;

public class CarteLaPlusHaute extends Combinaison {

	public CarteLaPlusHaute(ArrayList<Carte> main) {
		this.combinaisonDe = new ArrayList<Carte>();
		this.combinaisonDe.add(meilleureCarte(main));
		this.puissance = 1;
		if (main.size() == 1) {
			this.combinaisonSuivante = null;
		}else {
			ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
			clone.remove(this.combinaisonDe.get(0));
			this.combinaisonSuivante = new CarteLaPlusHaute(clone);
		}
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
	public int compareTo(Combinaison c) {
		int comp = this.combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
		if(comp != 0) {
			return comp;
		}else if (this.combinaisonSuivante != null){
			return this.combinaisonSuivante.compareTo(c.combinaisonSuivante);
		}
		return 0;
	}
}
