package jeu;

import java.util.ArrayList;

public class Combinaison implements Comparable<Combinaison> {

	protected int puissance;
	protected ArrayList<Carte> combinaisonDe;
	protected Combinaison combinaisonSuivante;

	public Combinaison() {}

	public Combinaison(int puissance, ArrayList<Carte> combinaisonDe, Combinaison combinaisonSuivante) {
		this.puissance = puissance;
		this.combinaisonDe = combinaisonDe;
		this.combinaisonSuivante = combinaisonSuivante;
	}

	public int getPuissance() {
		return puissance;
	}

	public Combinaison findBestComb(ArrayList<Carte> main) {

		int size = main.size();

		switch (size) {
		case 5:
			// TODO autres combi
			if (isBrelan(main))
				return new Brelan(main);
			if (isPaire(main))
				return new Paire(main);
			return new CarteLaPlusHaute(main);

		case 4:
			// TODO autres combi
			if (isBrelan(main))
				return new Brelan(main);
			if (isPaire(main))
				return new Paire(main);
			return new CarteLaPlusHaute(main);

		case 3:
			if (isBrelan(main))
				return new Brelan(main);
			if (isPaire(main))
				return new Paire(main);
			return new CarteLaPlusHaute(main);

		case 2:
			if (isPaire(main))
				return new Paire(main);
			return new CarteLaPlusHaute(main);

		case 1:
			return new CarteLaPlusHaute(main);

		default:
			return null;
		}
	}

	@Override
	public int compareTo(Combinaison c) {
		return Integer.compare(getPuissance(), c.getPuissance());
	}


	public boolean isBrelan(ArrayList<Carte> main) {
	    int  size = main.size();

	    if(size<3)
	    	return false;

	    for (int i = 0; i < size-2; i++)
	    	for(int j = i + 1; j < size-1; j++)
	    		for(int k = j + 1; k < size; k++)
	    			if (main.get(i).getValeur() == main.get(j).getValeur() && main.get(j).getValeur() == main.get(k).getValeur()) {
	    				return true;
	    			}

	    return false;
	  }

	public boolean isDoublePaire(ArrayList<Carte> main){
		int size = main.size();

		if(size < 4)
			return false;

		int nbPaire = 0;

		for (int i = 0; i < size - 1; i++) {
			for(int j = i+1 ; j < size; j++) {
				if (main.get(i).getValeur() == main.get(j).getValeur()) {
          i++;
				}
        if (nbPaire == 2) return true;
      }
    }
    return false;
	}

	public boolean isPaire(ArrayList<Carte> main) {
		int size = main.size();

		if(size < 2)
			return false;

		for(int i = 0; i < size-1; i++)
			for(int j = i+1; j < size; j++)
				if (main.get(i).getValeur() == main.get(j).getValeur())
					return true;

		return false;
	}

	public ArrayList<Carte> getCombinaisonDe() {
		return combinaisonDe;
	}

	public void setCombinaisonDe(ArrayList<Carte> combinaisonDe) {
		this.combinaisonDe = combinaisonDe;
	}

	public Combinaison getCombinaisonSuivante() {
		return combinaisonSuivante;
	}

	public void setCombinaisonSuivante(Combinaison combinaisonSuivante) {
		this.combinaisonSuivante = combinaisonSuivante;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public String toString() {
		return "";
	}
}
