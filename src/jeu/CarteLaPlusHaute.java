package jeu;

import java.util.ArrayList;

public class CarteLaPlusHaute extends Combinaison {
	private Carte carteHaute;

	public CarteLaPlusHaute(ArrayList<Carte> main) {
		this.carteHaute = meilleureCarte(main);
		this.puissance = 1;
		if (main.size() == 1) {
			this.combinaisonSuivante = null;
		}else {
			main.remove(this.carteHaute);
			this.combinaisonSuivante = new CarteLaPlusHaute(main);
		}
			
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
	public int compareTo(Combinaison c) {
		CarteLaPlusHaute c0 = (CarteLaPlusHaute) c; //#degeulassssssssssssssss
		int comp = this.carteHaute.compareTo(c0.carteHaute);
		if(comp != 0) {
			return comp;
		}else if (this.combinaisonSuivante != null){
			return this.combinaisonSuivante.compareTo(c.combinaisonSuivante);
		}
		return 0;
	}
}
