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

	public static final int maxCarte = 1;
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
		
		System.out.println("################\n"
				+ "Le joueur " + j1.getNom() + " gagne avec la main : "+j1.getMain());

		sc.close();

	}

	private boolean checkDuplicates() {
		for(Carte c : j1.getMain())
			if(j2.inHand(c))
				return true;
		
		return false;
	}

	public Joueur getGagnant(Joueur j1, Joueur j2){
		j1.getCombinaison().get(0).compareTo(j2.getCombinaison().get(0));
		return j1; // TODO return le bon gagnant
	}

	public static void main(String[] args) {
		Jeu maPartie = new Jeu();
		maPartie.lancement();
	}
}
