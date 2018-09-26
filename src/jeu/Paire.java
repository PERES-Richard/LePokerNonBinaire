package jeu;

import java.util.ArrayList;

public class Paire extends Combinaison{

  public Paire(ArrayList<Carte> main){
    this.combinaisonDe = new ArrayList<Carte>();
    this.combinaisonDe.addAll(getPaire(main));
    this.puissance = 2;
    if (main.size() == 2) {
			this.combinaisonSuivante = null;
		}else {
      for(int i=0; i<combinaisonDe.size(); i++)
			   main.remove(this.combinaisonDe.get(i));
			this.combinaisonSuivante = new CarteLaPlusHaute(main);
		}
  }

  public static boolean isPaire(ArrayList<Carte> main) {
    int i, j, size;

    size = main.size();

    i = 0;
    while (i < size - 1) {
      j = i + 1;
      while (j < size) {
        if (main.get(i).getValeur() == main.get(j).getValeur())
          return true;
        j++;
      }
      i++;
    }
    return false;
  }

  public ArrayList<Carte> getPaire(ArrayList<Carte> main){
    int i, j, size;
    ArrayList<Carte> list;

    list = new ArrayList<Carte>();
    size = main.size();

    i = 0;
    while (i < size - 1) {
      j = i + 1;
      while (j < size) {
        if (main.get(i).getValeur() == main.get(j).getValeur()){
          list.add(main.get(i));
          list.add(main.get(j));
          return list;
        }
        j++;
      }
      i++;
    }
    return null;
    }

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
}
