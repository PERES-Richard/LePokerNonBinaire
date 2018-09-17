package jeu;

import java.util.ArrayList;

public class Joueur {
	private String nom;
	
	private ArrayList<Carte> main;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.main = new ArrayList<Carte>();
	}
		
	public Joueur(ArrayList<String> main) throws CarteInvalideException{
		this.main = new ArrayList<Carte>();
		setMain(main);
	}
	
	public String getNom() {
		return nom;
	}
	
	public ArrayList<Carte> getMain() {
		return main;
	}
	
	public void setMain(ArrayList<String> main) throws CarteInvalideException{
		for(String carte : main) {
				this.main.add(convertToCarte(carte));
		}
	}
	
	public Carte convertToCarte(String carte) throws CarteInvalideException {
		int valeur;
		Couleur c;
		if (carte.length()==3) {
			c = findCouleur(carte.substring(1));
			String v = carte.substring(0,1);
			try {
				valeur = Integer.valueOf(v);
			}
			catch(Exception e) {
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
					default :
						throw new CarteInvalideException("Valeur invalide");
				}
			}
		}
		else if (carte.length()==4) {
			String v = carte.substring(0,2);
			if (Integer.valueOf(v)==10) {
				c = findCouleur(carte.substring(2));
				valeur = 10;
			}
			else
				throw new CarteInvalideException();
		}
		else
			throw new CarteInvalideException();
		
		return new Carte(c, valeur);
	}	
	
	public static Couleur findCouleur(String s) throws CarteInvalideException{
		switch(s) {
			case "Pi" :
				return Couleur.Pique;
			case "Co" :
				return Couleur.Coeur;
			case "Tr" :
				return Couleur.Trefle;
			case "Ca" :
				return Couleur.Carreau;
			default :
				throw new CarteInvalideException("Couleur inexistante");
		}
	}
}
