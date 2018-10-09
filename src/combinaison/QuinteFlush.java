package combinaison;

import java.util.ArrayList;

import jeu.Carte;

public class QuinteFlush extends Combinaison {
	
	QuinteFlush(ArrayList<Carte> main) {
		this.combinaisonDe = findQuinteFlush(main);
		this.puissance = 9;
		this.combinaisonSuivante = null;	
	}
	
	private ArrayList<Carte> findQuinteFlush(ArrayList<Carte> main){
		Carte c1 = main.get(0);
		Carte c2 = main.get(2);
		if (c1.getValeur() == 14 && c2.getValeur() == 5) {
			main.remove(c1);
			c1.setValeur(1);
			main.add(c1);
		}
		return main;
	}
	
	
	@Override
  	public int compareTo(Combinaison c) {
  		return this.combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
  	}
	
	public String toString() {
		return super.toString() + "Quinte Flush avec les cartes " + combinaisonDe;
	}

}
