package combinaison;

import java.util.ArrayList;

import jeu.Carte;

public class Full extends Combinaison{

	Full(ArrayList<Carte> main) {
		this.combinaisonDe = findFull(main);
		this.puissance = 7;
		this.combinaisonSuivante = null;
	}
	
	private ArrayList<Carte> findFull(ArrayList<Carte> main){
		
		ArrayList<Carte> full = new ArrayList<>();
		
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
  		return this.combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
  	}
	
	public String toString() {
		return "un Full (brelan de " + combinaisonDe.get(0).getSymbol() + " et paire de " + combinaisonDe.get(3).getSymbol() + ")";
	}
}
