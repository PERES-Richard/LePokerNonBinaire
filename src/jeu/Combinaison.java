package jeu;

import java.util.ArrayList;

public abstract class Combinaison implements Comparable<Combinaison> {

	protected int puissance;
	protected ArrayList<Carte> combinaisonDe;
	protected Combinaison combinaisonSuivante;

	public int getPuissance() {
		return puissance;
	}

	@Override
	public int compareTo(Combinaison c) {
		return Integer.compare(getPuissance(), c.getPuissance());
	}

}
