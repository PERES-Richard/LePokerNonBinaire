package jeu;

import java.util.ArrayList;
import java.util.Scanner;


/** Accents
 * 
è = \u00e8
é = \u00e9
ê = \u00ea
à = \u00e0
ù = \u00f9

 */


public class Jeu {
	private Joueur j1, j2;
	
	public void lancement() {
		
		System.out.println("Bienvenue sur la Main de Poker");
		
		//this.j1 = new Joueur("Jean");
		//this.j2 = new Joueur("Pierre");
		
		System.out.println("Veuillez rentrer les cartes de "+j1.getNom()+" (main 1)");
		saisieCarte(j1);
		System.out.println("Veuillez rentrer les cartes de "+j2.getNom()+" (main 2)");
		saisieCarte(j2);
		
		CarteLaPlusHaute temporaire = new CarteLaPlusHaute();
		
		System.out.println(temporaire.compare(j1.getMain(), j2.getMain()));
		System.out.println("Le joueur j1 a gagn\u00e8 avec la main:"+j1.getMain().get(0));
		
		
	}
	
	public void saisieCarte(Joueur j) {
		Scanner sc = new Scanner(System.in);
		String main = sc.nextLine();
		sc.close();
		//j.setMain();
	}

	public static void main() {
		Jeu maPartie = new Jeu();
		maPartie.lancement();
	}

}
