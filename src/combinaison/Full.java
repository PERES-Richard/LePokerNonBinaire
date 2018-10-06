package combinaison;

import java.util.ArrayList;

import jeu.Carte;

public class Full extends Combinaison{

	public Full(ArrayList<Carte> main) {
		this.combinaisonDe = findFull(main);
		this.puissance = 7;
		this.combinaisonSuivante = null;
	}
	
	private ArrayList<Carte> findFull(ArrayList<Carte> main){
		
		ArrayList<Carte> full = new ArrayList<Carte>();
		
		Combinaison brelan = new Brelan(main);
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(brelan.getCombinaisonDe());
		Combinaison paire = new Paire(clone);
		
		full.addAll(brelan.getCombinaisonDe());
		full.addAll(paire.getCombinaisonDe());
		
		return full;
	}
	
	@Override
  	public int compareTo(Combinaison c) {
  		int comp = this.combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
  		if(comp != 0) {
  			return comp;
  		}
  		return 0;
  	}
	
	public String toString() {
		return super.toString() + "Full, brelan de " + combinaisonDe.get(0).getSymbol() +
				" avec les cartes " + combinaisonDe.get(0) + ", " + combinaisonDe.get(1) + ", " + combinaisonDe.get(2) +
				" et paire "+ combinaisonDe.get(3).getSymbol() +
				" avec les cartes " + combinaisonDe.get(3) + ", " + combinaisonDe.get(4);
	}
}
