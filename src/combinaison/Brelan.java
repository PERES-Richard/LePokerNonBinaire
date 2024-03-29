package combinaison;

import java.util.ArrayList;

import jeu.Carte;

public class Brelan extends Combinaison{

	Brelan(ArrayList<Carte> main){
		this.combinaisonDe = findBrelan(main);
		this.puissance = 4;
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(combinaisonDe);
		this.combinaisonSuivante = findBestComb(clone);
	}

	private ArrayList<Carte> findBrelan(ArrayList<Carte> main) {
		
		ArrayList<Carte> brelan = new ArrayList<>();
		
		int size = main.size();
		Carte b1,b2,b3;
		
		for (int i = 0; i < size-2; i++) {
			b1 = main.get(i);
			b2 = main.get(i+1);
			b3 = main.get(i+2);
			if (b1.getValeur() == b2.getValeur() && b2.getValeur() == b3.getValeur()) {
				brelan.add(b1);
				brelan.add(b2);
				brelan.add(b3);
				return brelan;
			}
		}
		return null;
	}

	@Override
  	public int compareTo(Combinaison c) {
  		return this.combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
  	}

	public String toString() {
		return "un Brelan de " + combinaisonDe.get(0).getSymbol() + " (et avec " + combinaisonSuivante + ")";
	}
}
