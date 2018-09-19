package jeu;

import java.util.ArrayList;

public class Joueur {
	private String nom;
	private ArrayList<Carte> main;
	
		
	public Joueur(String nom, String main){
		this.nom = nom;
		this.main = setMain(main);
	}
	
	public String getNom() {
		return nom;
	}
	
	public ArrayList<Carte> getMain() {
		return main;
	}
	
	public ArrayList<Carte> setMain(String main){
		return Carte.convertToCarte(main);
	}
}
