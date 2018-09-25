package jeu;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Combinaison implements Comparator<ArrayList<Carte>>, Comparable<Combinaison> {
	
	private int puissance;
	
	public int getPuissance() {
		return puissance;
	}
	
	public void setPuissance(int i) {
		this.puissance = i;
	}
	

}