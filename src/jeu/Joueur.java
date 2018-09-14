package jeu;

public class Joueur {
	private String nom;
	
	private String main;
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getMain() {
		return main;
	}
	
	public void setMain(String main) {
		this.main = main;
	}

}
