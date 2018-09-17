package jeu;

public class Carte {
	
	private int valeur;
	private Couleur couleur;
	
	public Carte(int valeur) {
		this.valeur = valeur;
	}
	
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
	
	public String getSymbol() {
		switch(this.getValeur()) {
			case 14:
				return "As";
			case 13:
				return "Roi";
			case 12:
				return "Dame";
			case 11:
				return "Valet";
			default:
				return ""+this.getValeur();
		}
	}
	
	public String toString() {
		return ""+this.getSymbol()+" de "+this.getCouleur();
	}
}
