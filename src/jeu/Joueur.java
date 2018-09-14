package jeu;

import java.util.ArrayList;

public class Joueur {
	private String nom;
	
	private ArrayList<Carte> main;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.main = new ArrayList<Carte>();
	}
		
	public Joueur(ArrayList<String> main) {
		this.main = new ArrayList<Carte>();
		setMain(main);
	}
	
	public String getNom() {
		return nom;
	}
	
	public ArrayList<Carte> getMain() {
		return main;
	}
	
	public void setMain(ArrayList<String> main) {
		for(String carte : main) {
			this.main.add(new Carte(Integer.parseInt(carte)));
		}
	}

}
