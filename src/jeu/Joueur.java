package jeu;

import java.util.ArrayList;

public class Joueur {
	private String nom;
	private ArrayList<Carte> main;
	private ArrayList<Combinaison> comb;

	public Joueur(String nom){
		this.nom = nom;
	}

	public Joueur(String nom, String main){
		this.nom = nom;
		this.main = doMain(main);
		this.comb = findCombinaison(this.main);
	}

	public void setMain(String main){
		this.main = Carte.convertToCarte(main);
	}

	public String getNom() {
		return nom;
	}

	public ArrayList<Carte> getMain() {
		return main;
	}

	public ArrayList<Combinaison> getCombinaison() {
		return comb;
	}

	public ArrayList<Carte> doMain(String main){
		return Carte.convertToCarte(main);
	}

	public ArrayList<Combinaison> findCombinaison(ArrayList<Carte> main) {

		ArrayList<Combinaison> temp = new ArrayList<Combinaison>();

		CarteLaPlusHaute cHaute = new CarteLaPlusHaute(main);
		temp.add(cHaute);

		//Ici on pourra ajouter les combinaisons dans l'ordre inverse de puissance
		//comme �a on comparera le premier element de la liste

		return temp;
	}

	public boolean dansMain(Carte carte) {
		return this.main.contains(carte);
	}
}
