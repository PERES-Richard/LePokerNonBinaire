package jeu;

import java.util.ArrayList;

public class Paire extends Combinaison{

	public Paire(ArrayList<Carte> main){
		this.combinaisonDe = findPaire(main);
		this.puissance = 2;
		ArrayList<Carte> clone = (ArrayList<Carte>) main.clone();
		clone.removeAll(combinaisonDe);
		this.combinaisonSuivante = findBestComb(clone);
	}
	
	public ArrayList<Carte> findPaire(ArrayList<Carte> main){
		
		ArrayList<Carte> paire = new ArrayList<Carte>();
		
		int size = main.size();
		
		Carte p1,p2;
		for (int i = 0; i < size-1; i++) {
			p1 = main.get(i);
			p2 = main.get(i+1);
			if (p1.getValeur() == p2.getValeur()) {
				paire.add(p1);
				paire.add(p2);
				return paire;
			}
		}
		return null;
	}
	
	/*public ArrayList<Carte> getPaire(ArrayList<Carte> main){
		
		int size = main.size();

		ArrayList<Carte> list = new ArrayList<Carte>();

		for (int i = 0; i < size - 1; i++)
			for(int j = i+1 ; j < size; j++)
				if (main.get(i).getValeur() == main.get(j).getValeur()) {
					list.add(main.get(i));
					list.add(main.get(j));
					return list;
				}

		return null;
	}*/

    @Override
    public int compareTo(Combinaison c) {
  		int comp = this.combinaisonDe.get(0).compareTo(c.combinaisonDe.get(0));
  		if(comp != 0) {
  			return comp;
  		}else if (this.combinaisonSuivante != null){
  			return this.combinaisonSuivante.compareTo(c.combinaisonSuivante);
  		}
  		return 0;
  	}
    
    public String toString() {
		return super.toString() + "Paire de " + combinaisonDe.get(0).getSymbol() + " avec les cartes " + combinaisonDe + " et comme combinaison secondaire :" + combinaisonSuivante;
	}
}
