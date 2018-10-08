package combinaison;

import java.util.ArrayList;

import jeu.Carte;

public class QuinteFlush extends Combinaison {
	
	public QuinteFlush(ArrayList<Carte> main) {
		this.combinaisonDe = main;
		this.puissance = 9;
		this.combinaisonSuivante = null;	
	}
	
	@Override
  	public int compareTo(Combinaison c) {
  		return this.combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
  	}
	
	public String toString() {
		return super.toString() + "Quinte Flush avec les cartes " + combinaisonDe;
	}

}
