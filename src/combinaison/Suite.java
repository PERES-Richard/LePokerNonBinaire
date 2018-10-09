package combinaison;

import java.util.ArrayList;
import jeu.Carte;

public class Suite extends Combinaison{

  Suite(ArrayList<Carte> main){
		this.combinaisonDe = findSuite(main);
		this.puissance = 5;
		this.combinaisonSuivante = null;
	}

	private ArrayList<Carte> findSuite(ArrayList<Carte> main){
		int size = main.size();
		boolean as = false;
        Carte c1 = main.get(0);
        Carte c2 = main.get(1);
        int val1 = c1.getValeur();
        int val2 = c2.getValeur();
        
        if (val1 == 14 && val2 == 5) {
        	val1 = 6;
        	main.get(0).setValeur(1);
        	as = true;
        }

		for (int i = 1; i < size; i++) {
			if (val1-i != main.get(i).getValeur())
                return null;
		}
		
		if(as) {
			main.remove(c1);
			main.add(c1);
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
