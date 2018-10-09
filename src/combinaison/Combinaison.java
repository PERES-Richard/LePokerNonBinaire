package combinaison;

import java.util.ArrayList;

import jeu.Carte;
import jeu.Couleur;

public abstract class Combinaison implements Comparable<Combinaison> {

	protected int puissance;
	protected ArrayList<Carte> combinaisonDe;
	protected Combinaison combinaisonSuivante;

	public int getPuissance() {
		return puissance;
	}

	public static Combinaison findBestComb(ArrayList<Carte> main) {

		int size = main.size();

		switch (size) {
		case 5:
			if (isQuinteFlush(main))
				return new QuinteFlush(main);
			if (isCarre(main))
				return new Carre(main);
			if (isFull(main))
				return new Full(main);
			if (isFlush(main))
				return new Flush(main);
			if (isSuite(main))
				return new Suite(main);
			if (isBrelan(main))
				return new Brelan(main);
			if (isDoublePaire(main))
				return new DoublePaire(main);
			if (isPaire(main))
				return new Paire(main);
			return new CarteLaPlusHaute(main);

		case 4:
			if (isCarre(main))
				return new Carre(main);
			if (isBrelan(main))
				return new Brelan(main);
			if (isDoublePaire(main))
				return new DoublePaire(main);
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

	public static boolean isPaire(ArrayList<Carte> main) {

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
	
	private static boolean isPaire(ArrayList<Carte> main, int valeurExclue) {

		int size = main.size();
		Carte p1,p2;

		for (int i = 0; i < size-1; i++) {
			p1 = main.get(i);
			p2 = main.get(i+1);
			if (p1.getValeur() != valeurExclue && p1.getValeur() == p2.getValeur())
				return true;
		}
		return false;
	}

	public static boolean isDoublePaire(ArrayList<Carte> main) {

		if(main.size() < 4)
			return false;

		boolean isPaire1;
		boolean isPaire2 = false;

		if((isPaire1 = isPaire(main))) {
			Combinaison paire1 = new Paire(main);

			ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
			clone.removeAll(paire1.getCombinaisonDe());

			isPaire2 = isPaire(clone);
		}

		return isPaire1 && isPaire2;
	}

	public static boolean isBrelan(ArrayList<Carte> main) {
		int size = main.size();
		
		if(main.size() < 3)
			return false;
		
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
	
	public static boolean isSuite(ArrayList<Carte> main) {
		int size = main.size();

		if (size < 5)
			return false;

    	Carte c1 = main.get(0);
    	int val1 = c1.getValeur();
    	Carte c2 = main.get(1);
    	int val2 = c2.getValeur();
    	
    	if (val1 == 14 && val2 == 5)
        	val1 = 6;

		for (int i = 1; i < size; i++) {
			if (val1-i != main.get(i).getValeur())
        		return false;
		}
		return true;
	}

	public static boolean isFlush(ArrayList<Carte> main) {

		if(main.size() < 5)
			return false;

		Couleur couleur = main.get(0).getCouleur();

		for(Carte c : main)
			if(c.getCouleur() != couleur)
				return false;

		return true;
	}

	public static boolean isFull(ArrayList<Carte> main) {

		if(main.size() < 5)
			return false;

		if (isBrelan(main)) {
			Combinaison brelan = new Brelan(main);
			return isPaire(main, brelan.getCombinaisonDe().get(0).getValeur());
		}
		return false;
	}
	
	public static boolean isCarre(ArrayList<Carte> main) {

		int size = main.size();
		Carte c1,c2,c3,c4;

		for (int i = 0; i < size-3; i++) {
			c1 = main.get(i);
			c2 = main.get(i+1);
			c3 = main.get(i+2);
			c4 = main.get(i+3);
			if (c1.getValeur() == c2.getValeur() && c2.getValeur() == c3.getValeur() && c3.getValeur() == c4.getValeur())
					return true;
		}
		return false;
	}

	public static boolean isQuinteFlush(ArrayList<Carte> main) {
		if(main.size() < 5)
			return false;

		return isFlush(main) && isSuite(main);
	}


	public ArrayList<Carte> getCombinaisonDe() {
		return combinaisonDe;
	}
	public Combinaison getCombinaisonSuivante() {
		return combinaisonSuivante;
	}

	public String toString() {
		return "";
	}
}
