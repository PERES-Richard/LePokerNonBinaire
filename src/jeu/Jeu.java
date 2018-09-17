package jeu;

import java.util.ArrayList;
import java.util.Scanner;


public class Jeu {
	private Scanner s;
	private Joueur j1, j2;
	
	public void lancement(String[] args) {
		System.out.println("Bienvenue sur la Main de Poker");
		this.j1 = new Joueur("Jean");
		this.j2 = new Joueur("Pierre");
		System.out.println("Veuillez rentrer les cartes de "+j1.getNom()+"(main 1)");
		saisieCarte(args, j1);
		System.out.println("Veuillez rentrer les cartes de "+j2.getNom()+"(main 2)");
		saisieCarte(args, j2);
		fin();
		
		
	}
	
	public void saisieCarte(String[] args, Joueur j) {
		s = new Scanner(System.in);
		String main = s.nextLine();
		s.reset();
		try {
			j.setMain(traitement(main));
		}
		catch(CarteInvalideException e) {
			System.exit(0);
		}
	
	}
	
	private ArrayList<String> traitement(String main){
		String[] cartes = main.split(" ");
		ArrayList<String> mainTraitee = new ArrayList<String>();
		for(String str : cartes)
			mainTraitee.add(str);	
		return mainTraitee;
	}
	
	public void fin() {
		System.out.println("Le joueur j1 a gagné avec la main:"+j1.getMain().get(0));
		s.close();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu maPartie = new Jeu();
		maPartie.lancement(args);
	}

}
