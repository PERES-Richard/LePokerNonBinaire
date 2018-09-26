package jeu;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Combinaison implements Comparable<Combinaison> {

	protected int puissance;
	protected Carte cominaisonDe;
	protected Combinaison combinaisonSuivante;

	public int getPuissance() {
		return puissance;
	}

	public static Combinaison initCombinaison(ArrayList<Carte> main) {
		if (Paire.isPaire(main)) return new Paire(main);
		return new CarteLaPlusHaute(main);
	}

	@Override
	public int compareTo(Combinaison c) {
		return Integer.compare(this.getPuissance(), c.getPuissance());
	}

}
