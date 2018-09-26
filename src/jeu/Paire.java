package jeu;

import java.util.ArrayList;

public class Paire extends Combinaison{

  public Paire(ArrayList<Carte> main){
    this.cominaisonDe = getPaire(main);
    this.puissance = 2;
    if (main.size() == 2) {
			this.combinaisonSuivante = null;
		}else {
			main.remove(this.cominaisonDe);
      main.remove(this.cominaisonDe);
			this.combinaisonSuivante = new CarteLaPlusHaute(main);
		}
  }

  /*public Paire(ArrayList<Carte> main, int valeur){
    this.cominaisonDe = getPaire(main, valeur)                pour la Double Paire
    setPuissance(3);
  }*/
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

  public Carte getPaire(ArrayList<Carte> main){
    int i, j, size;

    size = main.size();

    i = 0;
    while (i < size - 1) {
      j = i + 1;
      while (j < size) {
        if (main.get(i).getValeur() == main.get(j).getValeur())
          return main.get(i);
      }
    }
      //Carte carteP;
      /*ArrayList<Carte> temp;
      for (Carte carteP : main){
        temp = main;
        main.remove(carteP);
        for (Carte carteQ : main){
          if(carteP.getValeur() == carteQ.getValeur())
            return carteP.getValeur();
        }
      }*/
      return null;
    }

    @Override
  	public int compareTo(Combinaison c) {
  		int comp = this.cominaisonDe.compareTo(c.cominaisonDe);
  		if(comp != 0) {
  			return comp;
  		}else if (this.combinaisonSuivante != null){
  			return this.combinaisonSuivante.compareTo(c.combinaisonSuivante);
  		}
  		return 0;
  	}
}
