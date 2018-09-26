package jeu;

import java.util.ArrayList;

public class Paire extends Combinaison{

        private int paireDe;

        public Paire(){}

        public Paire(ArrayList<Carte> main){
                this.paireDe = getPaire(main);
                this.puissance = 2;
        }

        /*public Paire(ArrayList<Carte> main, int valeur){
                this.paireDe = getPaire(main, valeur)                pour la Double Paire
                setPuissance(3);
        }*/

        public int getPaire(ArrayList<Carte> main){
                //Carte carteP;
                ArrayList<Carte> temp;
                for (Carte carteP : main){
                        temp = main;
                        main.remove(carteP);
                        for (Carte carteQ : main){
                                if(carteP.getValeur() == carteQ.getValeur())
                                        return carteP.getValeur();
                        }
                }
                return 0;
        }
}
