package jeu;

import java.util.Scanner;


/** Accents

e aigu = \u00e8
e grave = \u00e9
e circonflexe = \u00ea
a accent = \u00e0
u accent = \u00f9

 */

/** Cartes Possibles

 {2,3,4,5,6,7,8,9,10,V,D,R,A}x{Pi,Co,Tr,Ca}

 */


public class Jeu {

	public static final int maxCarte = 2;
	private Joueur j1, j2;
	private Scanner sc;

	public void lancement() {

		sc = new Scanner(System.in);

		System.out.println("Bienvenue sur le Poker Non Binaire\n");


		boolean reload = true;

		while(reload) {

			boolean mainJ1Valide = false;
			boolean mainJ2Valide = false;

			while (!mainJ1Valide)
				try {
					System.out.print("Main de J1 : ");
					j1 = new Joueur("J1", sc.nextLine());
					mainJ1Valide = true;
				} catch (Exception e) {
					System.out.println("\n/!\\Erreur dans la saisie de carte : " + e.getMessage() + ". Recommencer la saisie.\n");
				}


			while (!mainJ2Valide)
				try {
					System.out.print("Main de J2 : ");
					j2 = new Joueur("J2", sc.nextLine());
					mainJ2Valide = true;
				} catch (Exception e) {
					System.out.println("\n/!\\Erreur dans la saisie de carte : " + e.getMessage() + ". Recommencer la saisie.\n");
				}

			reload = checkDuplicates();
			if (reload) {
				System.out.println("Erreur, J1 et J2 ne peuvent pas avoir une carte en commun. Recommencer la saisie.\n################\n");
			}
		}

		if (getGagnant() == null) {
			System.out.println("Egalite");
		}
		else {
			System.out.println("Le joueur " + getGagnant().getNom() + " gagne avec la main " +getGagnant().getMain()); // TODO : Output chelou, gagnant premiere carte
		}
		sc.close();

	}

	private boolean checkDuplicates() {
		for(Carte c : j1.getMain())
			if(j2.getMain().contains(c))
				return true;

		return false;
	}



	public Joueur getGagnant(){

		if (j1.getCombinaison().getPuissance() > j2.getCombinaison().getPuissance())
			return j1;
		else if(j1.getCombinaison().getPuissance() < j2.getCombinaison().getPuissance())
			return j2;
		else {
			switch(j1.getCombinaison().compareTo(j2.getCombinaison())) {
				case -1 :
					return j2;
				case 1 :
					return j1;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Jeu maPartie = new Jeu();
		maPartie.lancement();
	}
}
