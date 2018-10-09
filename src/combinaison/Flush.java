package combinaison;

import java.util.ArrayList;

import jeu.Carte;

public class Flush extends Combinaison{

	Flush(ArrayList<Carte> main) {
		this.combinaisonDe = main;
		this.puissance = 6;
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(combinaisonDe);
		this.combinaisonSuivante = findBestComb(clone);
	}

	@Override
  	public int compareTo(Combinaison c) {
		for(int i=0; i<combinaisonDe.size(); i++)
			if(combinaisonDe.get(i).compareTo(c.combinaisonDe.get(i)) != 0)
				return combinaisonDe.get(i).compareTo(c.combinaisonDe.get(i));
		return 0;
  	}

	public String toString() {
		String s = "une Couleur (";
		for(Carte c : combinaisonDe) {
			s += c.getSymbol() + ", ";
		}
		return s.substring(0, s.length()-2) + " de " + combinaisonDe.get(0).getCouleur() +")";
	}
}
