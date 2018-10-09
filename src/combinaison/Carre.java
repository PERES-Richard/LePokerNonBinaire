package combinaison;

import java.util.ArrayList;

import jeu.Carte;

public class Carre extends Combinaison{

	Carre(ArrayList<Carte> main) {
		this.combinaisonDe = findCarre(main);
		this.puissance = 8;
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(combinaisonDe);
		this.combinaisonSuivante = findBestComb(clone);
	}

	private ArrayList<Carte> findCarre(ArrayList<Carte> main) {

		ArrayList<Carte> carre = new ArrayList<>();

		int size = main.size();
		Carte c1,c2,c3,c4;

		for (int i = 0; i < size-3; i++) {
			c1 = main.get(i);
			c2 = main.get(i+1);
			c3 = main.get(i+2);
			c4 = main.get(i+3);
			if (c1.getValeur() == c2.getValeur() && c2.getValeur() == c3.getValeur() && c3.getValeur() == c4.getValeur()) {
				carre.add(c1);
				carre.add(c2);
				carre.add(c3);
				carre.add(c4);
				return carre;
			}
		}
		return null;
	}

	@Override
  	public int compareTo(Combinaison c) {
  		return this.combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
  	}

	public String toString() {
		return super.toString() + "Carr\u00e9 de " + combinaisonDe.get(0).getSymbol() + " avec les cartes " + combinaisonDe + " et comme combinaison secondaire :" + combinaisonSuivante;
	}
}
