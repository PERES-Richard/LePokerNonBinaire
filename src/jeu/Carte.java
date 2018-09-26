package jeu;

import java.util.ArrayList;

public class Carte implements Comparable<Carte> {

	private int valeur;
	private Couleur couleur;

	public Carte(Couleur couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public Carte(String valeur, String couleur) throws Exception {
		setCouleur(couleur, valeur+couleur);
		setValeur(valeur, valeur+couleur);
	}

	public Carte(String main) throws Exception {
		setCouleur(main.substring(main.length() - 2, main.length()), main);
		setValeur(main.substring(0, main.length() - 2), main);
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public void setValeur(String valeur, String carte) throws Exception {
		if (valeur.length() > 2 || valeur.length() < 0) {
			throw new Exception(new Exception("Carte \"" + carte + "\" invalide : Valeur \"" + valeur + "\" incorrect"));
		}

		if (valeur.length() == 2) {
			int v = 11;

			try {
				v = Integer.parseInt(valeur);
			} catch (NumberFormatException e) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide : Valeur \"" + valeur + "\" incorrect"));
			}

			if (v > 10) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide : Valeur \"" + valeur + "\" incorrect"));
			}
			this.valeur = v;

		} else {
			int v = 1;

			try {
				v = Integer.parseInt(valeur);
			} catch (NumberFormatException e) {
				if(valeur.equalsIgnoreCase("V"))
					v = 11;
				if(valeur.equalsIgnoreCase("D"))
					v = 12;
				if(valeur.equalsIgnoreCase("R"))
					v = 13;
				if(valeur.equalsIgnoreCase("A"))
					v = 14;
			}

			if (v == 1) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide : Valeur \"" + valeur + "\" incorrect"));
			}
			else this.valeur = v;
		}
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public void setCouleur(String couleur, String carte) {
		if(couleur.equalsIgnoreCase("pi"))
			this.couleur = Couleur.Pique;
		if(couleur.equalsIgnoreCase("ca"))
			this.couleur = Couleur.Carreau;
		if(couleur.equalsIgnoreCase("co"))
			this.couleur = Couleur.Coeur;
		if(couleur.equalsIgnoreCase("tr"))
			this.couleur = Couleur.Trefle;
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

	public static ArrayList<Carte> convertToCarte(String main) throws Exception {

		ArrayList<Carte> mainCartes = new ArrayList<Carte>();

		String[] cartes = main.split(" ");

		if (cartes.length > Jeu.maxCarte) {
			throw new Exception(new Exception("Trop de cartes"));
		}

		for (String carte : cartes) {
			if (carte.length() > 4 || carte.length() < 3) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide"));
			}
			if(mainCartes.contains(new Carte(carte))) {
				throw new Exception(new Exception("Cette carte est d\u00e8j\u00e0 dans la main du joueur"));
			}
			mainCartes.add(new Carte(carte));
		}
		System.out.println(mainCartes+"\n");
		return mainCartes;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Carte) {
			if(toString().equals(obj.toString()))
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Carte c2) {
		return Integer.compare(this.getValeur(), c2.getValeur());
	}

}
