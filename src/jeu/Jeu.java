package jeu;

import java.util.Scanner;


public class Jeu {
	private Scanner s;
	private Joueur j1;
	
	public void lancement(String[] args) {
		System.out.println("Bienvenue sur la Main de Poker");
		this.j1 = new Joueur();
		System.out.println("Veuillez rentrer les cartes du joueur");
		saisieCarte(args, j1);
		fin();
		
		
	}
	
	public void saisieCarte(String[] args, Joueur j) {
		s = new Scanner(System.in);
		String main = s.nextLine();
		s.close();
		j.setMain(main);
		
	}
	
	public void fin() {
		System.out.println("Le joueur a gagné avec la main:"+j1.getMain());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu maPartie = new Jeu();
		maPartie.lancement(args);
	}

}
