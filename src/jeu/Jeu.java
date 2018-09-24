package jeu;

import java.util.ArrayList;
import java.util.Scanner;


/** Accents

e aigu = \u00e8
e grave = \u00e9
e circonflexe = \u00ea
a accent = \u00e0
u accent = \u00f9

 */

/** Cartes Possibles

 {2,3,4,5,6,7,8,9,10,J,Q,K,A}x{Pi,Co,Tr,Ca}

 */


public class Jeu {

	public static final int maxCarte = 1;
	private Joueur j1, j2;
	private Scanner sc;

	public void lancement() {

		System.out.println("Bienvenue sur la Main de Poker");

		this.j1 = new Joueur("Jean");
		this.j2 = new Joueur("Pierre");

		System.out.println("Veuillez rentrer les cartes de J1");
		saisieCarte(j1);
		System.out.println("\nVeuillez rentrer les cartes de J2");
		saisieCarte(j2);
		sc.close();

		//CarteLaPlusHaute temporaire = new CarteLaPlusHaute();

		//System.out.println(temporaire.compare(j1.getMain(), j2.getMain()));
		System.out.println("Le joueur j1 a gagn\u00e8 avec la main:"+j1.getMain());


	}

	public Joueur getGagnant(Joueur j1, Joueur j2){
		j1.getCombinaison().get(0).compareTo(j2.getCombinaison().get(0));
		return j1;
		//return j2;
	}

	public void saisieCarte(Joueur j) {
		sc = new Scanner(System.in);
		j.setMain(sc.nextLine());
	}

	public static void main(String[] args) {
		Jeu maPartie = new Jeu();
		maPartie.lancement();
	}
}
