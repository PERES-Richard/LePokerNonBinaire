package jeu;

import java.util.ArrayList;

public class Joueur {
	
	private ArrayList<Carte> main;
	private String nom;
	
	public Joueur(String nom, ArrayList<Carte> main) {
		this.nom = nom;
		this.main = main;
	}
	
	
	public ArrayList<Carte> getMain() {
		return main;
	}



	public void setMain(ArrayList<Carte> main) {
		this.main = main;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String toString() {
		return "Le joueur " + nom + " à :" + main;
	}
}
