package combinaison;

import java.util.ArrayList;
import jeu.Carte;

public class Suite extends Combinaison{

  public Suite(ArrayList<Carte> main){
		this.combinaisonDe = findSuite(main);
		this.puissance = 5;
		this.combinaisonSuivante = null;
	}

	private ArrayList<Carte> findSuite(ArrayList<Carte> main){
		int size = main.size();
        Carte c1 = main.get(0);
        int val = c1.getValeur();

		for (int i = 1; i < size; i++) {
			if (val-i != main.get(i).getValeur())
                return null;
		}
		return main;
	}

    @Override
    public int compareTo(Combinaison c) {
  		return this.combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
  	}

    public String toString() {
		return super.toString() + "Suite de " + combinaisonDe.get(0).getSymbol() + " avec les cartes " + combinaisonDe + " et comme combinaison secondaire :" + combinaisonSuivante;
	}
}