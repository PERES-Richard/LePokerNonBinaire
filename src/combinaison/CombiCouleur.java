package combinaison;

import java.util.ArrayList;

import jeu.Carte;
import jeu.Couleur;

public class CombiCouleur extends Combinaison{

	public CombiCouleur(ArrayList<Carte> main) {
		this.combinaisonDe = main;
		this.puissance = 6;
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(combinaisonDe);
		this.combinaisonSuivante = findBestComb(clone);
	}

	@Override
  	public int compareTo(Combinaison c) {
  		return combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
  	}

	public String toString() {
		return super.toString() + "Couleurs avec " + combinaisonDe;
	}
}
