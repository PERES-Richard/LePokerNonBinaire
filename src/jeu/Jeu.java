package jeu;

import java.util.Scanner;


/* Accents

e grave = \u00e8
e aigu = \u00e9
e circonflexe = \u00ea
a accent = \u00e0
u accent = \u00f9

 */


/**
 * Sert à lancer une partie de poker à 2 joueurs. Il faut dans un premier temps entrer la main du joueur 1 dans la console puis celle du joueur 2.
 * Le gagnant est décidé après avoir rentré les 2 mains.
 * <br><br>Une main est composé obligatoirement de <i>nbCartes</i> cartes sous la forme suivante :
 * <i>"2Pi"</i>, avec <i>"2"</i> = valeur de la carte (entre <i>2</i> et <i>9</i> ou <i>V</i>, <i>D</i>, <i>R</i> ou <i>A</i>)
 * et <i>"Pi"</i> la couleur de la carte (parmis <i>Pi</i>, <i>Co</i>, <i>Ca</i> ou <i>Tr</i>). Une carte n'est pas soumis à la casse.
 * <br><br>Chaque carte est séparer par au moins un espace et/ou tabulation.
 * 
 * @author <a href="mailto:Armand.BOULANGER@etu.univ-cotedazur.fr">Armand BOULANGER</a>
 * @author <a href="mailto:Sacha.CARNIERE@etu.univ-cotedazur.fr">Sacha CARNIERE</a>
 * @author <a href="mailto:Sylvain.MASIA@etu.univ-cotedazur.fr">Sylvain MASIA</a>
 * @author <a href="mailto:Richard.PERES@etu.univ-cotedazur.fr">Richard PERES</a>
 *
 */
public class Jeu {

	/**
	 *  Indique le nombre de carte de chaque joueur pour la partie
	 */
	static final int nbCarte = 5;
	
	/**
	 * Joueurs de la partie
	 * 
	 * @see Joueur
	 */
	private Joueur j1, j2;

	/**
	 * Méthode principale de la classe servant à démarrer la partie
	 */
	private void lancement() {

		/**
		 * Scanner lisant les mains des 2 joueurs sur la console
		 *
		 * @see Scanner
		 */
		Scanner sc = new Scanner(System.in);

		System.out.println("Bienvenue sur le Poker Non Binaire\n");

		boolean reload = true;

		// tant qu'il y a une erreur dans la saisie de la main des joueurs, ont recommence la saisie
		while(reload) {

			boolean mainJ1Valide = false;
			boolean mainJ2Valide = false;

			while (!mainJ1Valide)
				try {
					System.out.print("Main de J1 : ");
					// Input et instanciation de la main de J1
					j1 = new Joueur("J1", sc.nextLine());
					mainJ1Valide = true;
				} catch (Exception e) {
					System.out.println("\n/!\\ Erreur dans la saisie de carte : " + e.getMessage() + ". Recommencer la saisie.\n");
				}

			while (!mainJ2Valide)
				try {
					System.out.print("Main de J2 : ");
					// Input et instanciation de la main de J2
					j2 = new Joueur("J2", sc.nextLine());
					mainJ2Valide = true;
				} catch (Exception e) {
					System.out.println("\n/!\\ Erreur dans la saisie de carte : " + e.getMessage() + ". Recommencer la saisie.\n");
				}
			
			// Vérification d'une potentielle carte en double
			reload = checkDuplicates();
			if (reload) {
				System.out.println("Erreur, J1 et J2 ne peuvent pas avoir une carte en commun. Recommencer la saisie.\n################\n");
			}
		}

		if (getGagnant(j1, j2) == null) {
			System.out.println("Egalite");
		}
		else {
			System.out.println("Le joueur " + getGagnant(j1, j2).getNom() + " gagne avec " +getGagnant(j1, j2).getCombinaison());
		}

		sc.close();
		System.exit(0);

	}

	/**
	 * Fonction permettant de détecter une carte commune au 2 joueurs.
	 * 
	 * @return true si une carte est en doublon, false sinon
	 */
	private boolean checkDuplicates() {
		for(Carte c : j1.getMain())
			if(j2.getMain().contains(c))
				return true;

		return false;
	}


	/**
	 * Fonction qui détermine le gagnant entre les joueurs j1 et j2 en fonction de leur main respective.
	 * 
	 * @see Joueur
	 * 
	 * @param j1 Joueur 1
	 * @param j2 Joueur 2
	 * 
	 * @return Le gagnant parmis les 2 joueurs en entré
	 */
	public Joueur getGagnant(Joueur j1, Joueur j2){

		if (j1.getCombinaison().getPuissance() > j2.getCombinaison().getPuissance())
			return j1;
		else if(j1.getCombinaison().getPuissance() < j2.getCombinaison().getPuissance())
			return j2;
		else {
			switch(j1.getCombinaison().compareTo(j2.getCombinaison())) {
				case -1 :
					return j2;
				case 1 :
					return j1;
			}
		}
		return null;
	}

	/**
	 * Main du jeu qui lance une partie
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		Jeu maPartie = new Jeu();
		maPartie.lancement();
	}
}