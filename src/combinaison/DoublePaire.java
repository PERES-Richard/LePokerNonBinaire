package combinaison;

import java.util.ArrayList;

import jeu.Carte;

public class DoublePaire extends Combinaison {

	public DoublePaire(ArrayList<Carte> main) {
		this.combinaisonDe = findDoublePaire(main);
		this.puissance = 3;
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(combinaisonDe);
		this.combinaisonSuivante = findBestComb(clone);
	}

	private ArrayList<Carte> findDoublePaire(ArrayList<Carte> main) {

		ArrayList<Carte> doublePaire = new ArrayList<Carte>();
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
		return super.toString() + "Deux paires, une de " + combinaisonDe.get(0).getSymbol() +
				" avec les cartes " + combinaisonDe.get(0) + ", " + combinaisonDe.get(1) +
				" et une de "+ combinaisonDe.get(2).getSymbol() +
				" avec les cartes " + combinaisonDe.get(2) + ", " + combinaisonDe.get(3) +
				" et comme combinaison secondaire : " + combinaisonSuivante;
	}
}
