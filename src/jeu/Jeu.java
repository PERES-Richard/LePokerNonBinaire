package jeu;

import java.util.Scanner;

public class Jeu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Main du J1 : ");
		String mainJ1 = sc.next();
		
		System.out.print("Main du J2 : ");
		String mainJ2 = sc.next();
		
		Joueur j1 = new Joueur("J1", Carte.getCartes(mainJ1));
		Joueur j2 = new Joueur("J2", Carte.getCartes(mainJ2));
		
		System.out.println("// J1 : " + j1);
		System.out.println("// J2 : "+ j2);

		
		System.out.println("###############\n"
				+ "Bravo J1, tu as gagné !");
	}

}
