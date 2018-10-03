package jeu;

import java.util.ArrayList;

public class Brelan extends Combinaison{

	public Brelan(ArrayList<Carte> main){
		this.combinaisonDe = findBrelan(main);
		this.puissance = 4;
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(combinaisonDe);
		this.combinaisonSuivante = findBestComb(clone);
	}

	public ArrayList<Carte> findBrelan(ArrayList<Carte> main) {
	    int  size = main.size();
	    ArrayList<Carte> list = new ArrayList<Carte>();

	    for (int i = 0; i < size-2; i++) {
	    	for(int j = i + 1; j < size-1; j++) {
	    		for(int k = j + 1; k < size; k++) {
	    			if (main.get(i).getValeur() == main.get(j).getValeur() && main.get(j).getValeur() == main.get(k).getValeur()) {
	    				list.add(main.get(i));
	          	list.add(main.get(j));
	          	list.add(main.get(k));
	          	return list;
	    			}
	    		}
	    	}
	    }
	    return null;
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
		return super.toString() + "Brelan de " + combinaisonDe.get(0).getSymbol() + " avec les cartes " + combinaisonDe + " et comme combinaison secondaire :" + combinaisonSuivante;
	}
}
