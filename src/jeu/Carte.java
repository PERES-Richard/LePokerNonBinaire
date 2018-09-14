package jeu;

public class Carte {
	
	private int valeur;
	private Couleur couleur;
	
	public Carte(Couleur couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
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
