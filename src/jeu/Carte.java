package jeu;

import java.util.ArrayList;

public class Carte {
	
	private int valeur;
	private Couleur couleur;
	
	public Carte(Couleur couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public static ArrayList<Carte> getCartes(String mainJ1) {

		ArrayList<Carte> cartes = new ArrayList<>();
		
		// TODO : Récupérer les cartes depuis le string
		
		return cartes;
	}
	
	public Carte getCarte(String mainJ1) {

		// TODO : Récupérer la carte depuis le string
		
		//return new Carte();
		return null;
	}
	
	
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
}
