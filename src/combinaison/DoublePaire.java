package combinaison;

import java.util.ArrayList;

import jeu.Carte;

public class DoublePaire extends Combinaison {

	DoublePaire(ArrayList<Carte> main) {
		this.combinaisonDe = findDoublePaire(main);
		this.puissance = 3;
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(combinaisonDe);
		this.combinaisonSuivante = findBestComb(clone);
	}

	private ArrayList<Carte> findDoublePaire(ArrayList<Carte> main) {

		ArrayList<Carte> doublePaire = new ArrayList<>();
		Combinaison paire1 = new Paire(main);
		
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(paire1.getCombinaisonDe());
		Combinaison paire2 = new Paire(clone);
		
		doublePaire.addAll(paire1.getCombinaisonDe());
		doublePaire.addAll(paire2.getCombinaisonDe());
		
		return doublePaire;
	}

	@Override
  	public int compareTo(Combinaison c) {
  		if(combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0)) > 0){
  			return 1;
  		}
  		else if(combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0)) == 0){
  			if(combinaisonDe.get(3).compareTo(c.combinaisonDe.get(3)) == 0)
  					return combinaisonSuivante.compareTo(c.combinaisonSuivante);
  			return combinaisonDe.get(3).compareTo(c.combinaisonDe.get(3));
  		}
  		else return -1;
  	}

	public String toString() {
		return "une double paire de " + combinaisonDe.get(0).getSymbol() + " et de " + combinaisonDe.get(3).getSymbol() + " (et avec " + combinaisonSuivante + ")";
	}
}
