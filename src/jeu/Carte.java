package jeu;

import java.util.Comparator;

/**
 * Objet représentant une carte à jouer avec une Valeur (int entre 2 et 14) et une Couleur
 *
 * @see Couleur
 *
 * @author <a href="mailto:Armand.BOULANGER@etu.univ-cotedazur.fr">Armand BOULANGER</a>
 * @author <a href="mailto:Sacha.CARNIERE@etu.univ-cotedazur.fr">Sacha CARNIERE</a>
 * @author <a href="mailto:Sylvain.MASIA@etu.univ-cotedazur.fr">Sylvain MASIA</a>
 * @author <a href="mailto:Richard.PERES@etu.univ-cotedazur.fr">Richard PERES</a>
 *
 */
public class Carte implements Comparable<Carte> {

	private int valeur;
	private Couleur couleur;

	/**
	 * Instancie une carte avec une Couleur et une valeur (int)
	 *
	 * @see Couleur
	 *
	 * @param couleur Couleur de la carte
	 * @param valeur Valeur de la carte
	 */
	public Carte(Couleur couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}

	/**
	 * Instancie une carte avec une Couleur (String) et une valeur (String)
	 *
	 * @param couleur Couleur de la carte
	 * @param valeur Valeur de la carte
	 *
	 * @throws Exception Renvoi une exception si la valeur et/ou la couleur n'est pas valide
	 */
	public Carte(String valeur, String couleur) throws Exception {
		setCouleurFromStr(couleur, valeur+couleur);
		setValeurFromStr(valeur, valeur+couleur);
	}

	/**
	 * Instancie une carte avec une Couleur et une valeur (1 seule String)
	 *
	 * @param main Couleur et Valeur de la carte
	 *
	 * @throws Exception Renvoi une exception si la valeur et/ou la couleur n'est pas valide
	 */
	public Carte(String main) throws Exception {
		setCouleurFromStr(main.substring(main.length() - 2, main.length()), main);
		setValeurFromStr(main.substring(0, main.length() - 2), main);
	}

	/**
	 * Instancie la couleur de la carte depuis une String
	 *
	 * @param couleur Couleur de a carte
	 * @param carte Carte entière (pour gestion d'exception)
	 *
	 * @throws Exception Envoi une exception si la couleur est invalide
	 */
	public void setCouleurFromStr(String couleur, String carte) throws Exception {
		if(couleur.equalsIgnoreCase("pi"))
			this.couleur = Couleur.Pique;
		else if(couleur.equalsIgnoreCase("ca"))
			this.couleur = Couleur.Carreau;
		else if(couleur.equalsIgnoreCase("co"))
			this.couleur = Couleur.Coeur;
		else if(couleur.equalsIgnoreCase("tr"))
			this.couleur = Couleur.Trefle;
		else
			throw new Exception(new Exception("Carte \"" + carte + "\" invalide : Couleur \"" + couleur + "\" incorrect"));
	}

	/**
	 * Instancie la valeur de la carte depuis une String
	 *
	 * @param valeur Valeur de la carte
	 * @param carte Carte entière (pour gestion d'exception)
	 *
	 * @throws Exception Envoi une exception si la valeur est invalide
	 */
	public void setValeurFromStr(String valeur, String carte) throws Exception {
		// Si la valeur est plus longue que 2 caractères ou vide, envoi une exception
		if (valeur.length() > 2 || valeur.length() == 0) {
			throw new Exception(new Exception("Carte \"" + carte + "\" invalide : Valeur \"" + valeur + "\" incorrect"));
		}

		// Si la valeur est longue 2 caractères alors c'est obligatoirement un 10 sinon exception car valeur incorrecte
		if (valeur.length() == 2) {
			int v = 11;

			try {
				v = Integer.parseInt(valeur);
			} catch (NumberFormatException e) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide : Valeur \"" + valeur + "\" incorrect"));
			}

			if (v != 10) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide : Valeur \"" + valeur + "\" incorrect"));
			}
			this.valeur = v;

		}
		// Sinon c'est que c'est soit un nombre compris entre 2 et 9 ou une figure (V, D, R ou A)
		else {
			int v = 1;

			try {
				v = Integer.parseInt(valeur);

			}
			// Pas un entier valide donc peut etre une figure
			catch (NumberFormatException e) {
				if(valeur.equalsIgnoreCase("V"))
					v = 11;
				if(valeur.equalsIgnoreCase("D"))
					v = 12;
				if(valeur.equalsIgnoreCase("R"))
					v = 13;
				if(valeur.equalsIgnoreCase("A"))
					v = 14;
			}

			// Si ce n'est pas un entier valide ni une figure c'est une valeur incorrecte
			if (v == 1) {
				throw new Exception(new Exception("Carte \"" + carte + "\" invalide : Valeur \"" + valeur + "\" incorrect"));
			}
			else this.valeur = v;
		}
	}


	// Getters et Setters

	public int getValeur() { return valeur; }
	public void setValeur(int valeur) { this.valeur = valeur; }
	public Couleur getCouleur() { return couleur; }
	public void setCouleur(Couleur couleur) { this.couleur = couleur; }
	public String getSymbol() {
		switch (getValeur()) {
		case 14: case 1:
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


	// Override du toString() et des méthodes de comparaison equals() et compareTo()

	@Override
	public String toString() { return getSymbol() + " de " + getCouleur(); }
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Carte) {
			if(toString().equals(obj.toString()))
				return true;
		}
		return false;
	}
	@Override
	public int compareTo(Carte c2) { return Integer.compare(this.getValeur(), c2.getValeur()); }

}
