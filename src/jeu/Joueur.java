package jeu;

import java.util.ArrayList;
import java.util.Collections;

public class Joueur {
	private String nom;
	private ArrayList<Carte> main;
	private ArrayList<Combinaison> combinaisons;

	
	public Joueur(String nom, String main) throws Exception{
		this.nom = nom;
		setMain(main);
		findCombinaison();
	}

	private void setMain(String main) throws Exception{
		this.main = Carte.convertToCarte(main);
	}

	public ArrayList<Carte> getMain() { return main; }
	public ArrayList<Combinaison> getCombinaison() { return combinaisons; }
	public String getNom() { return nom; }

	
	public int getPuissanceTopCombinaison () {
		return this.getCombinaison().get(0).getPuissance();
	}
	private void findCombinaison() {
		combinaisons = new ArrayList<Combinaison>();
		combinaisons.add(new CarteLaPlusHaute(main));		
		Collections.sort(combinaisons, Collections.reverseOrder());

		//Ici on pourra ajouter les combinaisons dans l'ordre inverse de puissance
		//comme �a on comparera le premier element de la liste

	}
}
