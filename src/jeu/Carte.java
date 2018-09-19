package jeu;

import java.util.ArrayList;

public class Carte {

	private int valeur;
	private Couleur couleur;

	public Carte(Couleur couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public Carte(String valeur, String couleur) {
		setCouleur(couleur);
		setValeur(valeur);
	}

	public Carte(String main) {
		setCouleur(main.substring(main.length() - 2, main.length()));
		setValeur(main.substring(0, main.length() - 2));
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public void setValeur(String valeur) {
		if (valeur.length() > 2 || valeur.length() < 0) {
			// TODO exception "pas une valeur"
		}

		if (valeur.length() == 2) {
			int v = 11;

			try {
				v = Integer.parseInt(valeur);
			} catch (NumberFormatException e) {
				// TODO Pas un nombre donc pas une valeur valable
			}

			if (v > 10) {
				/** TODO exception pas une valeur valable */
			}
			this.valeur = v;

		} else {
			int v = 1;

			try {
				v = Integer.parseInt(valeur);
			} catch (NumberFormatException e) {
				// TODO Pas un nombre donc pas une valeur valable
			}

			if (v == 1) {
				/** TODO exception pas une valeur valable */
			}
			
			this.valeur = v;
		}
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public void setCouleur(String couleur) {
		switch (couleur) {
		case "Pi":
			this.couleur = Couleur.Pique;
		case "Co":
			this.couleur = Couleur.Coeur;
		case "Tr":
			this.couleur = Couleur.Trefle;
		case "Ca":
			this.couleur = Couleur.Carreau;
		default: // TODO exception
		}
	}

	public String getSymbol() {
		switch (getValeur()) {
		case 14:
			return "As";
		case 13:
			return "Roi";
		case 12:
			return "Dame";
		case 11:
			return "Valet";
		default:
			return "" + getValeur();
		}
	}

	public String toString() {
		return getSymbol() + " de " + getCouleur();
	}

	public static ArrayList<Carte> convertToCarte(String main) {

		ArrayList<Carte> mainCartes = new ArrayList<Carte>();

		String[] cartes = main.split(" ");

		if (cartes.length > Jeu.maxCarte) {
			/* TODO exception "trop de carte"} */}

		for (String carte : cartes) {
			if (carte.length() > 4 || carte.length() < 3) {
				/* TODO exception "pas une carte"} */}
				mainCartes.add(new Carte(carte));
		}
		System.out.println(mainCartes);
		return mainCartes;
	}

	/**
	 * 
	 * switch(v) { case "A" : valeur = 14; break; case "K" : valeur = 13; break;
	 * case "Q" : valeur = 12; break; case "J" : valeur = 11; break; }
	 * 
	 */
}
