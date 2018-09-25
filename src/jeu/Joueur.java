package jeu;

import java.util.ArrayList;

public class Joueur {
	private String nom;
	private ArrayList<Carte> main;
	private ArrayList<Combinaison> comb;

	
	public Joueur(String nom, String main) throws Exception{
		this.nom = nom;
		setMain(main);
		comb = findCombinaison(this.main);
	}

	private void setMain(String main) throws Exception{
		this.main = Carte.convertToCarte(main);
	}

	public ArrayList<Carte> getMain() { return main; }
	public ArrayList<Combinaison> getCombinaison() { return comb; }
	public String getNom() { return nom; }

	
	
	public ArrayList<Combinaison> findCombinaison(ArrayList<Carte> main) {

		ArrayList<Combinaison> temp = new ArrayList<Combinaison>();

		CarteLaPlusHaute cHaute = new CarteLaPlusHaute(main);
		temp.add(cHaute);

		//Ici on pourra ajouter les combinaisons dans l'ordre inverse de puissance
		//comme �a on comparera le premier element de la liste

		return temp;
	}

	public boolean inHand(Carte carte) {		
		for(Carte c : main)
			if(carte.toString().equals(c.toString()))
				return true;
		
		return false;
	}
}
