package jeu;

import java.util.ArrayList;

public class Carte {
	
	private int valeur;
	private Couleur couleur;
	
	public Carte(Couleur couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	public Carte(String main) {
		this.couleur = Couleur.Carreau;
		this.valeur = 0;
		//TODO
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
	
	public String getSymbol() {
		switch(getValeur()) {
			case 14:
				return "As";
			case 13:
				return "Roi";
			case 12:
				return "Dame";
			case 11:
				return "Valet";
			default:
				return ""+ getValeur();
		}
	}
	
	public String toString() {
		return getSymbol() + " de " + getCouleur();
	}

	public static ArrayList<Carte> convertToCarte(String main) {
		
		return null;
	}
	
	/**
	 * 
	 	switch(v) {
			case "A" :
				valeur = 14;
				break;
			case "R" : case "K" :
				valeur = 13;
				break;
			case "D" : case "Q" :
				valeur = 12;
				break;
			case "V" : case "J" :
				valeur = 11;
				break;
		}
				
				
		public Couleur findCouleur(String s){
			switch(s) {
				case "Pi" :
					return Couleur.Pique;
				case "Co" :
					return Couleur.Coeur;
				case "Tr" :
					return Couleur.Trefle;
				case "Ca" :
					return Couleur.Carreau;
				default : return null; // TODO exception
			}
		}
		
	 */
}
