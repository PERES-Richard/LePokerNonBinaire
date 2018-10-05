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
		int size = main.size();
		Carte b1,b2,b3;
		
		for (int i = 0; i < size-2; i++) {
			b1 = main.get(i);
			b2 = main.get(i+1);
			b3 = main.get(i+2);
			if (b1.getValeur() == b2.getValeur() && b2.getValeur() == b3.getValeur())
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
		Carte p1,p2;
		
		for (int i = 0; i < size-1; i++) {
			p1 = main.get(i);
			p2 = main.get(i+1);
			if (p1.getValeur() == p2.getValeur())
				return true;
		}
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
